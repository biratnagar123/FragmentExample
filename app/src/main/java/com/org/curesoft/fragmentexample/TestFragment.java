package com.org.curesoft.fragmentexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends Fragment {

    EditText e1;
    Button b1;
    frag_interface call_Back_Ref;
    public TestFragment() {
        // Required empty public constructor
    }
     interface frag_interface{
         public void sendData(String s) ;
     }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity= (Activity) context;
        try{

        call_Back_Ref= (frag_interface) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"override the method");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_test, container, false);
        e1= (EditText) v.findViewById(R.id.textOfFragment);
        b1= (Button) v.findViewById(R.id.buttonClick);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=e1.getText().toString();
                call_Back_Ref.sendData(text);
            }
        });
        return  v;

    }

    @Override
    public void onResume() {
        super.onResume();
        e1.setText("");
    }
}
