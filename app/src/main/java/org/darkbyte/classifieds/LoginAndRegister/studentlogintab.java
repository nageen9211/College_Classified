package org.darkbyte.classifieds.LoginAndRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.androidnetworking.interfaces.StringRequestListener;

import org.darkbyte.classifieds.R;
import org.darkbyte.classifieds.Splash;
import org.json.JSONObject;


public class studentlogintab extends Fragment {
Button signin;
    EditText username,password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_login_student_tab, container, false);
        signin=(Button)rootView.findViewById(R.id.student_login_btn);
        username=(EditText)rootView.findViewById(R.id.student_login_username);
        password=(EditText)rootView.findViewById(R.id.student_login_password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"asdsa",Toast.LENGTH_SHORT).show();
                AndroidNetworking.post("http://172.16.23.0/classifieds2/php/login.php")
                        .addBodyParameter("username", username.getText().toString())
                        .addBodyParameter("password", password.getText().toString())
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsString(new StringRequestListener() {

                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(getContext(),"tffg"+response+username.getText().toString()+password.getText().toString(),Toast.LENGTH_SHORT).show();
                                if(response.equals("correct")){
                                    startActivity(new Intent(getContext(), Splash.class));
                                }
                            }

                                @Override
                                public void onError(ANError anError) {
                                    Toast.makeText(getContext(),"aadas"+anError+username.getText().toString()+password.getText().toString(),Toast.LENGTH_SHORT).show();
                                    Log.v("adda" + anError, "");

                                }
                        });


            }
        });
        return rootView;
    }
}