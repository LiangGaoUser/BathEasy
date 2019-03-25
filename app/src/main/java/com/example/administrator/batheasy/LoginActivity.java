package com.example.administrator.batheasy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import static android.widget.Toast.LENGTH_SHORT;
public class LoginActivity extends AppCompatActivity {
    private Button login;
    private Button register;
    private EditText phoneText;
    private EditText pwdText;
    private RadioButton radioButton;
    private String telephone;
    private String password;
    private boolean symbol=false;
    private int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //
        Context mContext = getApplicationContext();
        final SharedHelper sh = new SharedHelper(mContext);

        Bmob.initialize(this, "82450cd6b2b2f6c72793f60b884c524c");
        login=(Button)this.findViewById(R.id.loginBtn);
        register = (Button) this.findViewById(R.id.registerBtn);
        phoneText=(EditText)this.findViewById(R.id.phoneText) ;
        pwdText=(EditText)this.findViewById(R.id.pwdText);
        if(sh.ReadMessage()){
            Map<String,String> data = sh.read();
            phoneText.setText(data.get("telephone"));
            pwdText.setText(data.get("passwd"));
            Toast.makeText(LoginActivity.this,"请输入完整信息", LENGTH_SHORT).show();
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                symbol=false;
                index=0;
                telephone=phoneText.getText().toString();
                password=pwdText.getText().toString();
                radioButton=(RadioButton)findViewById(R.id.radioButton);





                if(telephone.equals("")||password.equals("")){
                    Toast.makeText(LoginActivity.this,"请输入完整信息", LENGTH_SHORT).show();
                }else{
                    BmobQuery<User> bmobQuery = new BmobQuery<User>();
                    bmobQuery.findObjects(new FindListener<User>() {  //按行查询，查到的数据放到List<Goods>的集合
                    @Override
                public void done(List<User> list, BmobException e) {
                    if (e == null){
                        for(int i=0;i<list.size();i++){
                            if(telephone.equals(list.get(i).getTelephone().toString())&&password.equals(list.get(i).getPassword().toString())){
                               // Toast.makeText(LoginActivity.this,"查询到",LENGTH_SHORT);
                                symbol=true;
                                index=i;
                                break;
                            }
                        }
                        if(symbol){
                            Toast.makeText(LoginActivity.this,"查询成功！"+list.get(index).getTelephone()
                            +list.get(index).getPassword(), LENGTH_SHORT).show();
                            //保存密码和账号
                            if(radioButton.isChecked()){
                                sh.save( telephone, password);
                            }







                            phoneText.setText("");
                            pwdText.setText("");
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else{
                            phoneText.setText("");
                            pwdText.setText("");
                            Toast.makeText(LoginActivity.this,"账号或者密码错误，请重新输入！", LENGTH_SHORT).show();
                        }
                            //System.out.println("查询成功"+list.get(0).getTelephone()+list.get(0).getPassword());
                           // listView.setAdapter(new MyAdapter(GroundActivity.this , list));
                    }else{
                        Toast.makeText(LoginActivity.this,"表中没有元素", LENGTH_SHORT).show();
                    }

                }
            });
                }
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
          public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                //finish();
           }
        });
    }


    }

