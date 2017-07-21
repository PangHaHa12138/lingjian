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

import org.xclcharts.chart.BarData;
import org.xclcharts.chart.StackBarChart;
import org.xclcharts.common.DensityUtil;
import org.xclcharts.common.IFormatterDoubleCallBack;
import org.xclcharts.common.IFormatterTextCallBack;
import org.xclcharts.event.click.BarPosition;
import org.xclcharts.renderer.XEnum;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName StackBarChart01View
 * @Description  堆叠图 的例子   下发人员统计
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 */
public class StackBarChart04View extends DemoView {

	private String TAG = "StackBarChart04View";
	private StackBarChart chart = new StackBarChart();
	//标签轴
	List<String> chartLabels = new LinkedList<String>();
	List<BarData> BarDataSet = new LinkedList<BarData>();
	List<Data_Tubiaotongji.ListBean> list1;
	List<Data_Tubiaotongji.ListBean> list2;
	public int y = 1;
	public int tog = 1;

	Paint pToolTip = new Paint(Paint.ANTI_ALIAS_FLAG);

	public StackBarChart04View(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initView();
	}

	public StackBarChart04View(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
	 }

	 public StackBarChart04View(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			initView();
	 }
	 
	 private void initView()
	 {
		 chartLabels(list1,tog);
		 chartDataSet(list2,y);
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
			chart.setPadding(ltrb[0], ltrb[1], ltrb[2], DensityUtil.dip2px(getContext(), 55));	
			
			//显示边框
//			chart.showRoundBorder();
			
			chart.setChartDirection(XEnum.Direction.VERTICAL);
			//数据源		
			chart.setCategories(chartLabels);	
			chart.setDataSource(BarDataSet);
			this.invalidate();
//			//坐标系
//			chart.getDataAxis().setAxisMax(1024);
//			chart.getDataAxis().setAxisMin(0);
//			chart.getDataAxis().setAxisSteps(64);
			//指定数据轴标签旋转-45度显示
			chart.getCategoryAxis().setTickLabelRotateAngle(-45f);	
			Paint labelPaint = chart.getCategoryAxis().getTickLabelPaint();			
			labelPaint.setTextAlign(Align.RIGHT);
			labelPaint.setTypeface(Typeface.DEFAULT_BOLD);
			labelPaint.setColor(Color.rgb(0, 0, 0));
			
//			//标题
//			chart.setTitle("文件服务器空间使用情况");
//			chart.addSubtitle("(XCL-Charts Demo)");
//			chart.setTitleAlign(XEnum.HorizontalAlign.CENTER);
//			chart.setTitleVerticalAlign(XEnum.VerticalAlign.MIDDLE);
			
			//轴标题
//			chart.getAxisTitle().setLeftTitle("单位(TB)");
			
			//背景网格
//			chart.getPlotGrid().showEvenRowBgColor();
//			chart.getPlotGrid().showOddRowBgColor();
			chart.getDataAxis().getTickLabelPaint().setTextSize(25);
			chart.getDataAxis().getTickLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
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
			
			//定义柱形上标签显示格式
			chart.getBar().setItemLabelVisible(true);
			chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
				@Override
				public String doubleFormatter(Double value) {
					// TODO Auto-generated method stub
					DecimalFormat df=new DecimalFormat("");
					String label = df.format(value).toString();
					return label;
				}});	     
			
			//定义柱形上标签显示颜色
			chart.getBar().getItemLabelPaint().setColor(Color.rgb(245, 166, 54));
			chart.getBar().getItemLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
			chart.getBar().getItemLabelPaint().setTextSize(30);

			//激活点击监听
			chart.ActiveListenItemClick();
			chart.showClikedFocus();
			chart.setPlotPanMode(XEnum.PanMode.HORIZONTAL);
			
			chart.setBarCenterStyle(XEnum.BarCenterStyle.TICKMARKS);
			
			//chart.disablePanMode();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString());
		}
	}
	public int num;
	public List<Integer> numlist = new ArrayList<>();
	public List<Double> dataSeriesA;
	public List<Double> dataSeriesB;
	public List<Double> dataSeriesC;
	public void chartDataSet(List<Data_Tubiaotongji.ListBean> list1,int y) {
		if (y == 2){
			if (list1!=null&&list1.size()>0){
				dataSeriesA= new LinkedList<Double>();
				dataSeriesB= new LinkedList<Double>();
				dataSeriesC= new LinkedList<Double>();
				for (int i = 0; i < list1.size(); i++) {
					num = list1.get(i).getAllCount();
					numlist.add(num);
					//标签对应的柱形数据集
					dataSeriesA.add((double) list1.get(i).getSendCount());
					dataSeriesB.add((double) list1.get(i).getChexiao());
					dataSeriesC.add((double) list1.get(i).getZanting());
				}
				BarDataSet.clear();
				BarDataSet.add(new BarData("下发任务数",dataSeriesA,Color.rgb(82, 217, 247)));
				BarDataSet.add(new BarData("撤销任务数",dataSeriesB,Color.rgb(255, 217, 161)));
				BarDataSet.add(new BarData("暂停任务数",dataSeriesC,Color.rgb(255, 161, 161)));
				Collections.max(numlist);
				LogUtil.d("最大值是",Collections.max(numlist)+"");
				chart.getDataAxis().setAxisMax( Collections.max(numlist));
				if (Collections.max(numlist)>20){
					chart.getDataAxis().setAxisSteps(Collections.max(numlist)/20+1);
				}else {
					chart.getDataAxis().setAxisSteps(1);
				}
				chart.getDataAxis().setAxisMin(0);

				this.invalidate();
			}else {
//				ToastUtil.showToast("没有数据！");
				LogUtil.d("没有数据","error");
			}
		}else if (y == 1){
			if (list1!=null&&list1.size()>0){
				dataSeriesA= new LinkedList<Double>();
				dataSeriesB= new LinkedList<Double>();
				for (int i = 0; i < list1.size(); i++) {
					num = list1.get(i).getAllCount();
					numlist.add(num);
					//标签对应的柱形数据集
					dataSeriesA.add((double) list1.get(i).getDai());
					dataSeriesB.add((double) list1.get(i).getWan());
				}
				BarDataSet.clear();
				BarDataSet.add(new BarData("待办任务数",dataSeriesA,Color.rgb(75, 249, 244)));
				BarDataSet.add(new BarData("完成任务数",dataSeriesB,Color.rgb(210, 237, 159)));
				Collections.max(numlist);
				LogUtil.d("最大值是",Collections.max(numlist)+"");
				chart.getDataAxis().setAxisMax(Collections.max(numlist));
				if (Collections.max(numlist)>20){
					chart.getDataAxis().setAxisSteps(Collections.max(numlist)/20+1);
				}else {
					chart.getDataAxis().setAxisSteps(1);
				}
				chart.getDataAxis().setAxisMin(0);
				this.invalidate();
			}else {
//				ToastUtil.showToast("没有数据！");
				LogUtil.d("没有数据","error");
			}
		}


	}
	public void chartLabels(List<Data_Tubiaotongji.ListBean> list2,int tog) {
		if (tog == 1){
			if (list2!=null&&list2.size()>0){
				chartLabels.clear();
				chart.getPlotArea().extWidth(1);
				if (list2.size()>15){
					chart.getPlotArea().extWidth(list2.size()*80);
				}

				for (int i = 0; i < list2.size(); i++) {
					chartLabels.add((String) list2.get(i).getUsername());
				}
				this.invalidate();
			}
		}else if (tog == 2){
			if (list2!=null&&list2.size()>0){
				chartLabels.clear();
				chart.getPlotArea().extWidth(1);
				if (list2.size()>15){
					chart.getPlotArea().extWidth(list2.size()*80);
				}

				for (int i = 0; i < list2.size(); i++) {
					chartLabels.add((String) list2.get(i).getCount());
				}
				this.invalidate();
			}
		}
	}

	@Override
    public void render(Canvas canvas) {
        try{
        	
        	//chart.setChartRange(this.getMeasuredWidth(), this.getMeasuredHeight());
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
		
		int cid = record.getDataChildID();
		Double bValue = bData.getDataSet().get(cid);	
		String label = chartLabels.get(cid);		
		
		chart.showFocusRectF(record.getRectF());		
		chart.getFocusPaint().setStyle(Style.FILL);
		chart.getFocusPaint().setStrokeWidth(3);		
		chart.getFocusPaint().setColor(Color.GREEN);	
		chart.getFocusPaint().setAlpha(100);
		
		//在点击处显示tooltip
		pToolTip.setColor(Color.WHITE);		
		chart.getToolTip().setAlign(Align.CENTER);
		chart.getToolTip().setInfoStyle(XEnum.DyInfoStyle.CIRCLE);
		chart.getToolTip().getBackgroundPaint().setColor(Color.GRAY);
		
		//chart.getToolTip().setCurrentXY(record.getRectF().centerX(),record.getRectF().centerY());				
		chart.getToolTip().setCurrentXY(x,y);
		Double b = new Double(bValue);
		chart.getToolTip().addToolTip("任务个数:" + b.intValue(),pToolTip);
		
		this.invalidate();
		
	}
	
}
