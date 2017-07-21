/**
 * Copyright 2014  XCL-Charts
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 	
 * @Project XCL-Charts 
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @Copyright Copyright (c) 2014 XCL-Charts (www.xclcharts.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.0
 */
package com.hxzh.uniwill.lingjian.View;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.xclcharts.chart.BarData;
import org.xclcharts.chart.StackBarChart;
import org.xclcharts.common.DensityUtil;
import org.xclcharts.common.IFormatterDoubleCallBack;
import org.xclcharts.common.IFormatterTextCallBack;
import org.xclcharts.event.click.BarPosition;
import org.xclcharts.renderer.XEnum;
import org.xclcharts.renderer.axis.XYAxis;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.hxzh.uniwill.lingjian.bean.Data_Tubiaotongji;
import com.hxzh.uniwill.lingjian.utils.LogUtil;
import com.hxzh.uniwill.lingjian.utils.ToastUtil;

/**
 * @ClassName StackBarChart02View
 * @Description  堆叠图 的例子(横向)
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 */
public class StackBarChart02View extends DemoView {

	private String TAG = "StackBarChart02View";
	private StackBarChart chart = new StackBarChart();
	
	//标签轴
	List<String> chartLabels = new LinkedList<String>();
	List<BarData> BarDataSet = new LinkedList<BarData>();
	List<Data_Tubiaotongji.ListBean> list1;
	List<Data_Tubiaotongji.ListBean> list2;

	public int chosedat = 1;
	Paint pToolTip = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	public StackBarChart02View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initView();
	}
	public StackBarChart02View(Context context, AttributeSet attrs){
        super(context, attrs);   
        initView();
	 }
	 
	 public StackBarChart02View(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			initView();
	 }
	 
	 private void initView()
	 {
		 chartLabels(list1,chosedat);
		 chartDataSet(list2);
		 chartRender();
		//綁定手势滑动事件
			this.bindTouch(this,chart);
	 }
	 
	
	@Override  
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {  
        super.onSizeChanged(w, h, oldw, oldh);  
       //图所占范围大小
        chart.setChartRange(w,h);
    }  				
	
	
	private void chartRender()
	{
		try {		
			
			//设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....		
			int [] ltrb = getBarLnDefaultSpadding();
//			chart.setPadding(DensityUtil.dip2px(getContext(), 50),ltrb[1], ltrb[2],  ltrb[3]);
			chart.setPadding(ltrb[0], ltrb[1], ltrb[2], DensityUtil.dip2px(getContext(), 55));
			//显示边框
//			chart.showRoundBorder();

//			//指定显示为横向柱形
			chart.setChartDirection(XEnum.Direction.VERTICAL);

			//数据源
			chart.setPlotPanMode(XEnum.PanMode.VERTICAL);
			chart.setCategories(chartLabels);
			chart.setDataSource(BarDataSet);
			this.invalidate();
			//设置没有渐变
			chart.getBar().setBarStyle(XEnum.BarStyle.OUTLINE);
			//数据轴坐标系
//			chart.getDataAxis().setAxisMax(1200);
//			chart.getDataAxis().setAxisMin(100);
//			chart.getDataAxis().setAxisSteps(100);

			chart.getDataAxis().getTickLabelPaint().setTextSize(25);
			chart.getDataAxis().getTickLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
			//指定数据轴标签旋转-45度显示
			chart.getCategoryAxis().setTickLabelRotateAngle(45f);

			//标题
//			chart.setTitle("费用预算与实际发生对比");
//			chart.addSubtitle("(XCL-Charts Demo)");
//			chart.setTitleAlign(XEnum.HorizontalAlign.CENTER);
			//图例
			chart.getAxisTitle().setLowerTitle("单位为(个数)");
			
			//背景网格			
			chart.getPlotGrid().showVerticalLines();
			chart.getPlotGrid().setVerticalLineStyle(XEnum.LineStyle.DOT);
					
			
			//chart.getPlotGrid().setVerticalLinesVisible(true);
			//chart.getPlotGrid().setEvenRowsFillVisible(true);
			//chart.getPlotGrid().getEvenFillPaint().setColor((int)Color.rgb(225, 230, 246)); 

			//定义数据轴标签显示格式
			chart.getDataAxis().setLabelFormatter(new IFormatterTextCallBack(){

				@Override
				public String textFormatter(String value) {
					// TODO Auto-generated method stub
					DecimalFormat df=new DecimalFormat("#0");
					Double tmp = Double.parseDouble(value);
					String label = df.format(tmp).toString();
					return label;
				}

			});

			//定义标签轴标签显示颜色
			chart.getCategoryAxis().getTickLabelPaint().setColor(Color.rgb(0, 0, 0));
			chart.getCategoryAxis().getTickLabelPaint().setTextSize(25);
			chart.getCategoryAxis().getTickLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

			//定义柱形上标签显示格式
			chart.getBar().setItemLabelVisible(true);
			chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
				@Override
				public String doubleFormatter(Double value) {
					// TODO Auto-generated method stub
					DecimalFormat df=new DecimalFormat("#0");
					String label = df.format(value).toString();
					return label;
				}});	 
			//定义柱形上标签显示颜色
			chart.getBar().getItemLabelPaint().setColor(Color.rgb(245, 166, 54));
			//柱形形标签字体大小
			chart.getBar().getItemLabelPaint().setTextSize(25);
			chart.getBar().getItemLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
			//激活点击监听
			chart.ActiveListenItemClick();
			chart.showClikedFocus();
			chart.setPlotPanMode(XEnum.PanMode.HORIZONTAL);
			
			//设置柱子的最大高度范围，不然有些数据太少时，柱子太高不太好看。 
			chart.getBar().setBarMaxPxHeight(100.f);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString());
		}
	}
	public int num;
	public List<Double> numlist = new ArrayList<Double>();
	public List<Double> dataSeriesA;
	public List<Double> dataSeriesB;
	public void chartDataSet(List<Data_Tubiaotongji.ListBean> list1) {
		if (list1!=null&&list1.size()>0){
			dataSeriesA= new LinkedList<Double>();
			dataSeriesB= new LinkedList<Double>();
			for (int i = 0; i < list1.size(); i++) {
				 num = list1.get(i).getAllCount();
				numlist.add((double) num);
				//标签对应的柱形数据集

				dataSeriesA.add((double) list1.get(i).getDai());
				list1.get(i).getWan();

				dataSeriesB.add((double) list1.get(i).getWan());
			}
			BarDataSet.clear();
			BarDataSet.add(new BarData("待办任务数",dataSeriesA,Color.rgb(51, 254, 51)));
			BarDataSet.add(new BarData("完成任务数",dataSeriesB,Color.rgb(254, 227, 44)));
			Collections.max(numlist);
			LogUtil.d("最大值是",Collections.max(numlist)+"");
			chart.getDataAxis().setAxisMax( Collections.max(numlist));
			chart.getDataAxis().setAxisMin(0);
			chart.getDataAxis().setAxisSteps(1);
			this.invalidate();
		}else {
			ToastUtil.showToast("没有数据！");
		}

	}
	public void chartLabels(List<Data_Tubiaotongji.ListBean> list2,int chosedata) {
		if (list2!=null&&list2.size()>0){
			if (chosedata == 1){//月 2017-05
				chartLabels.clear();
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					String[] m = data.split("-");
					String data2 = m[0]+"-"+m[1];
					chartLabels.add(data2);
				}
			}else if (chosedata == 2){//季度 直接写
				chartLabels.clear();
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					chartLabels.add(data);
				}
			}else if (chosedata == 3){//年 2017
				chartLabels.clear();
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					String[] m = data.split("-");
					String data2 = m[0];
					chartLabels.add(data2);
				}
			}else if (chosedata == 4){//日 2017-05-11
				chartLabels.clear();
				if (list2.size()>20){
					chart.getPlotArea().extWidth(1500);
				}
				chart.getCategoryAxis().setAxisSteps(10);
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					chartLabels.add(data);
				}

			}
			this.invalidate();
		}

	}



	@Override
    public void render(Canvas canvas) {
        try{
        	//chart.setChartRange(this.getMeasuredWidth(), this.getMeasuredHeight());
        	
        	//chart.setChartRange(this.getWidth(), this.getHeight());
            chart.render(canvas);
        } catch (Exception e){
        	Log.e(TAG, e.toString());
        }
    }

	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub		
		super.onTouchEvent(event);		
		if(event.getAction() == MotionEvent.ACTION_UP) 
		{			
			triggerClick(event.getX(),event.getY());
		}
		return true;
	}
	
	
	//触发监听
	private void triggerClick(float x,float y)
	{
	
		BarPosition record = chart.getPositionRecord(x,y);			
		if( null == record) return;
		
		if(record.getDataID() >= BarDataSet.size()) return;
		BarData bData = BarDataSet.get(record.getDataID());					
		Double bValue = bData.getDataSet().get(record.getDataChildID());
		
		chart.showFocusRectF(record.getRectF());		
		chart.getFocusPaint().setStyle(Style.FILL);
		chart.getFocusPaint().setStrokeWidth(3);
		chart.getFocusPaint().setColor(Color.GRAY);	
		chart.getFocusPaint().setAlpha(100);
		
		//在点击处显示tooltip
		pToolTip.setColor(Color.WHITE);		
		chart.getToolTip().setAlign(Align.CENTER);
		chart.getToolTip().getBackgroundPaint().setColor(Color.GRAY);
		chart.getToolTip().setInfoStyle(XEnum.DyInfoStyle.CIRCLE);
//		chart.getToolTip().setCurrentXY(x,y);
		chart.getToolTip().setCurrentXY(record.getRectF().centerX(),record.getRectF().top);
		Double b = new Double(bValue);
		chart.getToolTip().addToolTip("任务个数:" + b.intValue(),pToolTip);

		this.invalidate();
	}

}
