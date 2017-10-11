package com.shanghaiintegralcalculus;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //头部
    private View vHead;
    private ListView listview;
    private TextView showone;
    private RelativeLayout computations;
    private TextView xuelis,zizhizhengming,shebaojishu,nashuijine,jiuyerenshu,chaungyerencai,fuwurencai;
    private EditText age,xujiacailiao,juliucishu,ganzuitiaoshu;
    //初始化学历

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=(ListView) findViewById(R.id.listview);
        //头布局
        vHead= View.inflate(MainActivity.this, R.layout.mainlistview, null);
        age=(EditText) vHead.findViewById(R.id.age);
        xujiacailiao=(EditText) vHead.findViewById(R.id.xujiacailiao);
        juliucishu=(EditText) vHead.findViewById(R.id.juliucishu);
        ganzuitiaoshu=(EditText) vHead.findViewById(R.id.ganzuitiaoshu);




        xuelis=(TextView) vHead.findViewById(R.id.xueli);
        xuelis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> xueli=new ArrayList<String>();
                xueli.add("大专（高职）学历");
                xueli.add("大学本科学历和学士学位");
                xueli.add("无");
                xueli.add("硕士研究生学历学位");
                xueli.add("博士研究生学历学位");
                show(xueli,1,"选择学历");
            }
        });
       //资质证明
        zizhizhengming=(TextView) vHead.findViewById(R.id.zizhizhengming);
        zizhizhengming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> zhizhizhengmings=new ArrayList<String>();
                zhizhizhengmings.add("技能类国家职业资格证五级");
                zhizhizhengmings.add("技能类国家职业资格证四级");
                zhizhizhengmings.add("技能类国家职业资格证三级");
                zhizhizhengmings.add("无");
                zhizhizhengmings.add("技能类国家职业资格证二级或中级职称");
                zhizhizhengmings.add("技能类国家职业资格证一级或高级职称");
                show(zhizhizhengmings,2,"选择资质证明");
            }
        });
        //社保基数
        shebaojishu=(TextView) vHead.findViewById(R.id.shebaojishu);
        shebaojishu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> shebaojishus=new ArrayList<String>();
                shebaojishus.add(">80%<1倍");
                shebaojishus.add(">1倍<2倍");
                shebaojishus.add("<=80%");
                shebaojishus.add(">2倍<3倍");
                shebaojishus.add(">3倍");


                show(shebaojishus,3,"选择社保基数");
            }
        });
        //纳税金额
        nashuijine=(TextView) vHead.findViewById(R.id.nashuijine);
        nashuijine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> nashui=new ArrayList<String>();
                for(int i=0;i<=12;i++)
                {
                    nashui.add(i*10+"万元");
                }
                show(nashui,4,"选择纳税金额");
            }
        });
        //3年带动人数
        jiuyerenshu=(TextView) vHead.findViewById(R.id.jiuyerenshu);
        jiuyerenshu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> daidongrenshu=new ArrayList<String>();
                for(int i=0;i<=12;i++)
                {
                    daidongrenshu.add(i+"人");
                }
                show(daidongrenshu,5,"选择带动人数");
            }
        });
        //创业人才
        chaungyerencai=(TextView) vHead.findViewById(R.id.chaungyerencai);
        chaungyerencai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> isor=new ArrayList<String>();
                isor.add("是");
                isor.add("否");
                show(isor,6,"选择创业人才");
            }
        });
        //是否是创新创业中介服务型人才
        fuwurencai=(TextView) vHead.findViewById(R.id.fuwurencai);
        fuwurencai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> isor=new ArrayList<String>();
                isor.add("是");
                isor.add("否");
                show(isor,7,"选择服务型人才");
            }
        });
        showone=(TextView) vHead.findViewById(R.id.showone);
        showone.setMovementMethod(ScrollingMovementMethod.getInstance());
        //头布局放入listView中
        listview.addHeaderView(vHead);

        listview.setAdapter(null);

        //计算积分
        computations=(RelativeLayout) findViewById(R.id.computations);
        computations.getBackground().setAlpha(86);
        computations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(xujiacailiao.getText().toString().equals(""))
                {
                    T.showShort(MainActivity.this,"有没有填的选项");
                }
                else if(juliucishu.getText().toString().equals(""))
                {
                    T.showShort(MainActivity.this,"有没有填的选项");
                }
                else if(ganzuitiaoshu.getText().toString().equals(""))
                {
                    T.showShort(MainActivity.this,"有没有填的选项");
                }
                else if(age.getText().toString().equals(""))
                {
                    T.showShort(MainActivity.this,"有没有填的选项");

                }
                else {
                    if (Integer.parseInt(age.getText().toString()) > 56) {
                        sum += 5;
                    } else {
                        sum += (56-(Integer.parseInt(age.getText().toString())))*2+5;
                    }
                    sum -= (150 * (Integer.parseInt(xujiacailiao.getText().toString())));
                    sum -= (50 * (Integer.parseInt(juliucishu.getText().toString())));
                    sum -= (150 * (Integer.parseInt(ganzuitiaoshu.getText().toString())));

                    Intent intent = new Intent(MainActivity.this, newActivity.class);
                    intent.putExtra("sum", sum);
                    startActivity(intent);
                }
            }
        });


    }

    public int sum=0;


    private String names;
    private int position;
    private  boolean is=true;
    public  void  show(List<String> nums, final int numis, final String name) {
        final PickerView pv=new PickerView(MainActivity.this);
        pv.setData(nums);
        pv.setOnSelectListener(new PickerView.onSelectListener() {
            @Override
            public void onSelect( String text,int position) {
                names=text;
                position=position;
                is=false;

            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(name);
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
        public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                  if(numis==1)
                  {
                      xuelis.setText(names);
                      if(is)
                      {
                          xuelis.setText("无");
                      }
                      else
                      {
                          is=true;
                          if(position==0) {
                              sum+=50;
                          }
                          else if(position==1)
                          {
                              sum+=60;
                          }else if(position==2)
                          {
                              sum+=0;
                              T.showShort(MainActivity.this,"+0");
                          }
                          else if(position==3)
                          {
                              sum+=90;
                          }
                          else if(position==4)
                          {
                              sum+=100;
                          }else if(position==5)
                          {
                              sum+=110;
                          }
                      }



                  }
                  else if(numis==2)
                  {
                      if(is)
                      {
                          zizhizhengming.setText("无");
                      }
                      else {
                          zizhizhengming.setText(names);
                          if (position == 0) {
                              sum += 15;
                          } else if (position == 1) {
                              sum += 30;
                          } else if (position == 2) {
                              sum += 0;
                          } else if (position == 3) {
                              sum += 60;
                          } else if (position == 4) {
                              sum += 100;
                          } else if (position == 5) {
                              sum += 140;
                          }
                          is=true;
                      }
                  }
                  else if(numis==3)
                  {
                      if(is)
                      {
                          shebaojishu.setText("<=80%");
                      }
                      else {
                          shebaojishu.setText(names);
                          if (position == 0) {
                              sum += 25;
                          } else if (position == 1) {
                              sum += 50;
                          } else if (position == 2) {
                              sum += 0;
                          } else if (position == 3) {
                              sum += 100;
                          } else if (position == 4) {
                              sum += 120;
                          }
                          is=true;
                      }
                  }
                  else if(numis==4)
                  {
                      if(is)
                      {
                          nashuijine.setText("60万");
                          sum+=60;
                      }
                      else {
                          nashuijine.setText(names);
                          sum += (position) * 10;
                          is=true;
                      }
                  }
                  else if(numis==5)
                  {
                      if(is)
                      {
                          jiuyerenshu.setText("6人");
                          sum+=60;
                      }
                      else
                      {
                          jiuyerenshu.setText(names);
                          sum+=(position)*10;
                          is=true;
                      }

                  }
                  else if(numis==6)
                  {
                      if(is)
                      {
                          chaungyerencai.setText("否");
                      }
                      else {
                          chaungyerencai.setText(names);
                          if (position == 1) {
                              sum += 120;
                          } else {

                          }
                          is=true;
                      }
                  }
                  else if(numis==7)
                  {

                      if(is)
                      {
                          fuwurencai.setText("否");
                      }
                      else {
                          fuwurencai.setText(names);
                          if (position == 1) {
                              sum += 120;
                          } else {

                          }
                          is=true;
                      }
                  }
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
        @Override
            public void onClick(DialogInterface dialog, int which)
            {
            dialog.dismiss();
            }
        });
        builder.setView(pv);
        builder.show();


    }
}
