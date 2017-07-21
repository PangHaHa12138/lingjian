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

import org.xclcharts.chart.LineChart;
import org.xclcharts.chart.LineData;
import org.xclcharts.common.IFormatterDoubleCallBack;
import org.xclcharts.common.IFormatterTextCallBack;
import org.xclcharts.event.click.PointPosition;
import org.xclcharts.renderer.XEnum;

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
 * @ClassName LineChart01View
 * @Description  折线图的例子
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 */
public class LineChart01View extends DemoView {
	
	private String TAG = "LineChart01View";
	private LineChart chart = new LineChart();
	
	//标签集合
	private LinkedList<String> labels = new LinkedList<String>();
	private LinkedList<LineData> chartData = new LinkedList<LineData>();
	List<Data_Tubiaotongji.ListBean> list1;
	List<Data_Tubiaotongji.ListBean> list2;
	public int chosedata = 1;
	public int tog = 1;

	private Paint mPaintTooltips = new Paint(Paint.ANTI_ALIAS_FLAG);
	
	
	public LineChart01View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initView();
	}
	
	public LineChart01View(Context context, AttributeSet attrs){   
        super(context, attrs);   
        initView();
	 }
	 
	 public LineChart01View(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			initView();
	 }
	 
	 private void initView()
	 {
		 	chartLabels(list1,chosedata);
			chartDataSet(list2,tog);
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
	
	private void chartRender() {
		try {				
			
			//设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....		
			int [] ltrb = getBarLnDefaultSpadding();
			chart.setPadding(ltrb[0], ltrb[1], ltrb[2], ltrb[3]);	
			
			//限制Tickmarks可滑动偏移范围
			chart.setXTickMarksOffsetMargin(ltrb[2] - 20.f);
			chart.setYTickMarksOffsetMargin(ltrb[3] - 20.f);

			chart.setPlotPanMode(XEnum.PanMode.HORIZONTAL);
			
			//显示边框
//			chart.showRoundBorder();
			
			
			//设定数据源
			chart.setCategories(labels);								
			chart.setDataSource(chartData);
			
//			//数据轴最大值
//			chart.getDataAxis().setAxisMax(100);
//			//数据轴刻度间隔
//			chart.getDataAxis().setAxisSteps(10);
			
			//背景网格
//			chart.getPlotGrid().showHorizontalLines();
			//chart.getPlotGrid().showVerticalLines();
//			chart.getPlotGrid().showEvenRowBgColor();
//			chart.getPlotGrid().showOddRowBgColor();
			
//			chart.getPlotGrid().getHorizontalLinePaint().setStrokeWidth(2);
//			chart.getPlotGrid().setHorizontalLineStyle(XEnum.LineStyle.DASH);
//			chart.getPlotGrid().setVerticalLineStyle(XEnum.LineStyle.DOT);
			
//			chart.getPlotGrid().getHorizontalLinePaint().setColor(Color.RED);
//			chart.getPlotGrid().getVerticalLinePaint().setColor(Color.BLUE);
			
//			chart.setTitle("折线图(Line Chart)");
//			chart.addSubtitle("(XCL-Charts Demo)");
//			chart.getAxisTitle().setLowerTitle("(年份)");
			
			//激活点击监听
			chart.ActiveListenItemClick();
			//为了让触发更灵敏，可以扩大5px的点击监听范围
			chart.extPointClickRange(10);
			chart.showClikedFocus();
												
			//绘制十字交叉线
//			chart.showDyLine();
//			chart.getDyLine().setDyLineStyle(XEnum.DyLineStyle.Vertical);
			
			//想隐藏轴的可以下面的函数来隐藏
//			chart.getDataAxis().hide();
//			chart.getCategoryAxis().hide();
			//想设置刻度线属性的可用下面函数
//			chart.getDataAxis().getTickMarksPaint()
//			chart.getCategoryAxis().getTickMarksPaint()
			//想设置刻度线标签属性的可用下面函数
//			chart.getDataAxis().getAxisTickLabelPaint()
//			chart.getCategoryAxis().setAxisSteps(30);
//			chart.getCategoryAxis().setAxisBuildStd(true);
//			chart.getPlotArea().extWidth(500);
			//调整轴显示位置
			chart.setDataAxisLocation(XEnum.AxisLocation.LEFT);
			chart.setCategoryAxisLocation(XEnum.AxisLocation.BOTTOM);
			chart.getCategoryAxis().getTickLabelPaint().setTextSize(20);
			chart.getCategoryAxis().getTickLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
			chart.getDataAxis().getTickLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
			chart.getDataAxis().getTickLabelPaint().setTextSize(25);
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

			chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
				@Override
				public String doubleFormatter(Double value) {
					DecimalFormat df=new DecimalFormat("#0");
					String label = df.format(value).toString();
					return label;
				}
			});
			//收缩绘图区右边分割的范围，让绘图区的线不显示出来
//			chart.getClipExt().setExtRight(0.f);
			
			
			//test x坐标从刻度线而不是轴开始
//			chart.setXCoordFirstTickmarksBegin(true);
//			chart.getCategoryAxis().showTickMarks();
//			chart.getCategoryAxis().setVerticalTickPosition(XEnum.VerticalAlign.MIDDLE);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString());
		}
	}
	public int num;
	public List<Integer> numlist = new ArrayList<>();
	public LinkedList<Double> dataSeriesA;
	public LinkedList<Double> dataSeriesB;
	public LinkedList<Double> dataSeriesC;
	public void chartDataSet(List<Data_Tubiaotongji.ListBean> list,int tog) {
		if (tog == 1){
			//Line 2
			if (list!= null&&list.size()>0){

				dataSeriesA= new LinkedList<Double>();
				dataSeriesB= new LinkedList<Double>();
				for (int i = 0; i < list.size(); i++) {
					num = list.get(i).getAllCount();
					numlist.add(num);
					dataSeriesA.add((double)list.get(i).getDai());
					dataSeriesB.add((double)list.get(i).getWan());
				}
				LineData lineData6 = new LineData("待办任务数",dataSeriesA,Color.rgb(75, 249, 244));


				lineData6.setDotStyle(XEnum.DotStyle.RING2);
				lineData6.getPlotLine().getDotPaint().setColor(Color.RED);
				lineData6.setLabelVisible(true);
				//lineData6.getPlotLine().getPlotDot().setRingInnerColor(Color.GREEN);
				//lineData6.getPlotLine().getPlotDot().setRing2InnerColor(Color.GREEN);
//			lineData6.setLineStyle(XEnum.LineStyle.DASH);
				lineData6.getDotLabelPaint().setColor(Color.rgb(212, 64, 39));
				lineData6.getLabelOptions().getBox().getBackgroundPaint().setColor(Color.rgb(57, 172, 241));
				lineData6.getLabelOptions().getBox().setBorderLineColor(Color.YELLOW);
				lineData6.getDotLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

				LineData lineData7 = new LineData("完成任务数",dataSeriesB,Color.rgb(210, 237, 159));

				lineData7.setDotStyle(XEnum.DotStyle.RING2);
				lineData7.getPlotLine().getDotPaint().setColor(Color.RED);
				lineData7.setLabelVisible(true);
				//lineData7.getPlotLine().getPlotDot().setRingInnerColor(Color.GREEN);
				//lineData7.getPlotLine().getPlotDot().setRing2InnerColor(Color.GREEN);
				//lineData7.setLineStyle(XEnum.LineStyle.DASH);
				lineData7.getDotLabelPaint().setColor(Color.rgb(212, 64, 39));
				lineData7.getLabelOptions().getBox().getBackgroundPaint().setColor(Color.rgb(57, 172, 241));
				lineData7.getLabelOptions().getBox().setBorderLineColor(Color.YELLOW);
				lineData7.getDotLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

				chartData.clear();
				chartData.add(lineData6);
				chartData.add(lineData7);
				Collections.max(numlist);
				LogUtil.d("最大值是",Collections.max(numlist)+"");
				chart.getDataAxis().setAxisMax(Collections.max(numlist)+2);
				if (Collections.max(numlist)>20){
					chart.getDataAxis().setAxisSteps(Collections.max(numlist)/20+1);
				}else {
					chart.getDataAxis().setAxisSteps(1);
				}
				chart.getDataAxis().setAxisMin(0);
				this.invalidate();
			}else {
//				ToastUtil.showToast("没有数据");
				LogUtil.d("没有数据","error");
			}
		}else if (tog == 2){
			//Line 2
			if (list!= null&&list.size()>0){

				dataSeriesA= new LinkedList<Double>();
				dataSeriesB= new LinkedList<Double>();
				dataSeriesC= new LinkedList<Double>();
				for (int i = 0; i < list.size(); i++) {
					num = list.get(i).getAllCount();
					numlist.add(num);
					dataSeriesA.add((double)list.get(i).getSendCount());
					dataSeriesB.add((double)list.get(i).getChexiao());
					dataSeriesC.add((double)list.get(i).getZanting());
				}
				LineData lineData6 = new LineData("下发任务数",dataSeriesA,Color.rgb(82, 217, 247));


				lineData6.setDotStyle(XEnum.DotStyle.RING2);
				lineData6.getPlotLine().getDotPaint().setColor(Color.RED);
				lineData6.setLabelVisible(true);
				//lineData6.getPlotLine().getPlotDot().setRingInnerColor(Color.GREEN);
				//lineData6.getPlotLine().getPlotDot().setRing2InnerColor(Color.GREEN);
//			lineData6.setLineStyle(XEnum.LineStyle.DASH);
				lineData6.getDotLabelPaint().setColor(Color.rgb(212, 64, 39));
				lineData6.getLabelOptions().getBox().getBackgroundPaint().setColor(Color.rgb(57, 172, 241));
				lineData6.getLabelOptions().getBox().setBorderLineColor(Color.YELLOW);
				lineData6.getDotLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

				LineData lineData7 = new LineData("撤销任务数",dataSeriesB,Color.rgb(255, 217, 161));

				lineData7.setDotStyle(XEnum.DotStyle.RING2);
				lineData7.getPlotLine().getDotPaint().setColor(Color.RED);
				lineData7.setLabelVisible(true);
				//lineData7.getPlotLine().getPlotDot().setRingInnerColor(Color.GREEN);
				//lineData7.getPlotLine().getPlotDot().setRing2InnerColor(Color.GREEN);
				//lineData7.setLineStyle(XEnum.LineStyle.DASH);
				lineData7.getDotLabelPaint().setColor(Color.rgb(212, 64, 39));
				lineData7.getLabelOptions().getBox().getBackgroundPaint().setColor(Color.rgb(57, 172, 241));
				lineData7.getLabelOptions().getBox().setBorderLineColor(Color.YELLOW);
				lineData7.getDotLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

				LineData lineData8 = new LineData("暂停任务数",dataSeriesC,Color.rgb(255, 161, 161));

				lineData8.setDotStyle(XEnum.DotStyle.RING2);
				lineData8.getPlotLine().getDotPaint().setColor(Color.RED);
				lineData8.setLabelVisible(true);
				//lineData8.getPlotLine().getPlotDot().setRingInnerColor(Color.GREEN);
				//lineData8.getPlotLine().getPlotDot().setRing2InnerColor(Color.GREEN);
				//lineData8.setLineStyle(XEnum.LineStyle.DASH);
				lineData8.getDotLabelPaint().setColor(Color.rgb(212, 64, 39));
				lineData8.getLabelOptions().getBox().getBackgroundPaint().setColor(Color.rgb(57, 172, 241));
				lineData8.getLabelOptions().getBox().setBorderLineColor(Color.YELLOW);
				lineData8.getDotLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);

				chartData.clear();
				chartData.add(lineData6);
				chartData.add(lineData7);
				chartData.add(lineData8);
				Collections.max(numlist);
				LogUtil.d("最大值是",Collections.max(numlist)+"");
				chart.getDataAxis().setAxisMax(Collections.max(numlist)+2);
				if (Collections.max(numlist)>20){
					chart.getDataAxis().setAxisSteps(Collections.max(numlist)/20+1);
				}else {
					chart.getDataAxis().setAxisSteps(1);
				}
				chart.getDataAxis().setAxisMin(0);
				this.invalidate();
			}else {
//				ToastUtil.showToast("没有数据");
				LogUtil.d("没有数据","error");
			}
		}


	}
	//X轴时间
	public void chartLabels(List<Data_Tubiaotongji.ListBean> list2,int chosedata)
	{
		if (list2!=null&&list2.size()>0){
			if (chosedata == 1){//月 2017-05
				labels.clear();
				chart.getPlotArea().extWidth(1);
				if (list2.size()>5){
					chart.getPlotArea().extWidth(list2.size()*80);
				}
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					String[] m = data.split("-");
					String data2 = m[0]+"-"+m[1];
					labels.add(data2);
				}
			}else if (chosedata == 2){//季度 直接写
				labels.clear();
				chart.getPlotArea().extWidth(1);
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					labels.add(data);
				}
			}else if (chosedata == 3){//年 2017
				labels.clear();
				chart.getPlotArea().extWidth(1);
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();
					String[] m = data.split("-");
					String data2 = m[0];
					labels.add(data2);
				}
			}else if (chosedata == 4){//日 2017-05-11
				labels.clear();

				if (list2.size()>7){
					chart.getPlotArea().extWidth(list2.size()*80);
				}

				chart.getCategoryAxis().setAxisSteps(10);
				for (int i = 0; i < list2.size(); i++) {
					String data = list2.get(i).getCount();//5-4
					String[] n = data.split("-");
					String haha = n[1]+"-"+n[2];
					labels.add(haha);
				}

			}
			this.invalidate();
		}

	}
	
	@Override
    public void render(Canvas canvas) {
        try{
            chart.render(canvas);
        } catch (Exception e){
        	Log.e(TAG, e.toString());
        }
    }

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub		
				
		if(event.getAction() == MotionEvent.ACTION_UP) 
		{			
			triggerClick(event.getX(),event.getY());
		}
		super.onTouchEvent(event);
		return true;
	}
	
	
	//触发监听
	private void triggerClick(float x,float y)
	{		
		
		//交叉线
		if(chart.getDyLineVisible())chart.getDyLine().setCurrentXY(x,y);		
		if(!chart.getListenItemClickStatus())
		{
			//交叉线
			if(chart.getDyLineVisible())this.invalidate();
		}else{			
			PointPosition record = chart.getPositionRecord(x,y);			
			if( null == record)
			{
				if(chart.getDyLineVisible())this.invalidate();
				return;
			}
	
			LineData lData = chartData.get(record.getDataID());
			Double lValue = lData.getLinePoint().get(record.getDataChildID());
		
			float r = record.getRadius();
			chart.showFocusPointF(record.getPosition(),r + r*0.5f);		
			chart.getFocusPaint().setStyle(Style.STROKE);
			chart.getFocusPaint().setStrokeWidth(3);		
			if(record.getDataID() >= 3)
			{
				chart.getFocusPaint().setColor(Color.BLUE);
			}else{
				chart.getFocusPaint().setColor(Color.RED);
			}		
			
			//在点击处显示tooltip
			mPaintTooltips.setColor(Color.WHITE);
			//chart.getToolTip().setCurrentXY(x,y);
			chart.getToolTip().setCurrentXY(record.getPosition().x,record.getPosition().y);
			chart.getToolTip().getBackgroundPaint().setColor(Color.GRAY);
			Double b = new Double(lValue);
//			chart.getToolTip().addToolTip(" Key:"+lData.getLineKey(),mPaintTooltips);
//			chart.getToolTip().addToolTip(" Label:"+lData.getLabel(),mPaintTooltips);
			chart.getToolTip().addToolTip("当前任务数:" +b.intValue(),mPaintTooltips);
				
			
			//当前标签对应的其它点的值
			int cid = record.getDataChildID();
			String xLabels = "";
			for(LineData data : chartData)
			{
				if(cid < data.getLinePoint().size())
				{
					Double c = new Double(data.getLinePoint().get(cid));
					xLabels = Integer.toString(b.intValue());

					chart.getToolTip().addToolTip("Line:"+data.getLabel()+":"+ xLabels,mPaintTooltips);
				}
			}
			
			
			this.invalidate();
		}
		
		
	}
	
	
}
