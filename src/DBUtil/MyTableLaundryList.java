package DBUtil;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import DTO.LaundryListDTO;

/*
 *TableModel��ģ���࣬���ڽ�Table�����ݰ���һ��
 *ͨ��List�洢�����ݿ���е����ݣ��ٽ�List������ʾ��JTable��
 */
public class MyTableLaundryList extends AbstractTableModel
{
	private List list = null;
	private Vector dataVector=new Vector();
	private String[] title= new String[]{"����", "�����", "��������", "���ѽ��", "����ʱ��","״̬"};
	public MyTableLaundryList(List list)
	{
		this.list=list;
	}
	
	public int getRowCount()
	{
	     return list.size(); 
    }
    
    public int getColumnCount()
    {
    	return 6;    		
    }
    
    public Object getValueAt(int row, int column){
    	if(row>=list.size()){
    		return null;
    	}
    	LaundryListDTO obj=(LaundryListDTO)list.get(row);
    		if(column==0){
    			return obj.getF_Name();
    		} 
    		else if(column ==1){
    			return obj.getF_Num();
    		} 
    		else if(column ==2){
    			return obj.getF_Type();
    		}
    		else if(column ==3)
    		{
    			return obj.getF_Money();
    		}
    		else if(column ==4){
    			return obj.getF_Time();
    		}
    		else if(column ==5){
    			return obj.getF_Ps();
    		}
    		
    		else{
    			return null;
    		}
    	}
    	
    public String getColumnName(int column)
    {
         return title[column];
    }
}