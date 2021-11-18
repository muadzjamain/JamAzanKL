package com.example.jam_azan2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jam_azan2.Config.Config;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

import java.math.BigDecimal;

public class Derma_Activity extends AppCompatActivity {
    private Button RM1Button;
    private Button RM2Button;
    private Button RM5Button;
    private Button RM10Button;
    private Button RM50Button;

    private static final int PAYPAL_REQUEST_CODE = 7171;

    private static PayPalConfiguration config =new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK) //use sandbox we on test
            .clientId("AfMbM5qU1wgC_DOIPwJejuVzyFnZe0W6YWXZbP62Cp-lNi19gMOITHegxrzHKhmztRrCJyuJBtjkdodZ");

    String amount="";

    @Override
    protected void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derma);

        //Start Paypal Service
        Intent intent = new Intent(Derma_Activity.this, PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        startService(intent);

        RM1Button=findViewById(R.id.rm1button);
        RM2Button=findViewById(R.id.rm2button);
        RM5Button=findViewById(R.id.rm5button);
        RM10Button=findViewById(R.id.rm10button);
        RM50Button=findViewById(R.id.rm50button);

        RM1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPayment();

            }

            private void processPayment() {
                amount="1";
                PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),"MYR",
                        "Donate for Azan",PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(Derma_Activity.this, PaymentActivity.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
                startActivityForResult(intent,PAYPAL_REQUEST_CODE);

            }
        });

        RM2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPayment();

            }

            private void processPayment() {
                amount="2";
                PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),"MYR",
                        "Donate for Azan",PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(Derma_Activity.this, PaymentActivity.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
                startActivityForResult(intent,PAYPAL_REQUEST_CODE);

            }
        });

        RM5Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPayment();

            }

            private void processPayment() {
                amount="5";
                PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),"MYR",
                        "Donate for Azan",PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(Derma_Activity.this, PaymentDetails.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
                startActivityForResult(intent,PAYPAL_REQUEST_CODE);

            }
        });

        RM10Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPayment();

            }

            private void processPayment() {
                amount="10";
                PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),"MYR",
                        "Donate for Azan",PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(Derma_Activity.this, PaymentActivity.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
                startActivityForResult(intent,PAYPAL_REQUEST_CODE);

            }
        });

        RM50Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processPayment();

            }

            private void processPayment() {
                amount="50";
                PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),"MYR",
                        "Donate for Azan",PayPalPayment.PAYMENT_INTENT_SALE);
                Intent intent = new Intent(Derma_Activity.this, PaymentActivity.class);
                intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
                intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
                startActivityForResult(intent,PAYPAL_REQUEST_CODE);

            }
        });

        Button to_settings1 = findViewById(R.id.to_settings1);

        to_settings1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSettings();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        startActivity(new Intent(this, PaymentDetails.class)
                                .putExtra("PaymentDetails", paymentDetails)
                                .putExtra("PaymentAmount", amount));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(this, "Invaild", Toast.LENGTH_SHORT).show();
        ;
    }

    public void openSettings() {
        Intent intent = new Intent(this, UserSettings_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

