/**
 * Copyright (c) 2002 sinosoft  Co. Ltd.
 * All right reserved.
 */

package com.sinosoft.lis.schema;

import org.apache.log4j.Logger;
import java.sql.*;
import java.io.*;
import java.util.Date;
import com.sinosoft.lis.pubfun.FDate;
import com.sinosoft.utility.*;
import com.sinosoft.lis.db.LRTermBDB;

/*
 * <p>ClassName: LRTermBSchema </p>
 * <p>Description: DB层 Schema 类文件 </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: sinosoft </p>
 * @Database: SqlServerSchemaMaker
 */
public class LRTermBSchema implements Schema, Cloneable
{
private static Logger logger = Logger.getLogger(LRTermBSchema.class);
	// @Field
	/** Edorno */
	private String EdorNo;
	/** Id */
	private String Id;
	/** Name */
	private String Name;
	/** Bomid */
	private String BomId;
	/** Remark */
	private String Remark;
	/** Displayorder */
	private int DisPlayOrder;
	/** State */
	private String State;
	/** Datatype */
	private String DataType;
	/** Caltype */
	private String CalType;
	/** Attribute */
	private String Attribute;
	/** Calsql */
	private String CalSql;
	/** Operator */
	private String Operator;
	/** Makedate */
	private Date MakeDate;
	/** Maketime */
	private String MakeTime;
	/** Modifydate */
	private Date ModifyDate;
	/** Modifytime */
	private String ModifyTime;
	/** Operator2 */
	private String Operator2;
	/** Makedate2 */
	private Date MakeDate2;
	/** Maketime2 */
	private String MakeTime2;
	/** Modifydate2 */
	private Date ModifyDate2;
	/** Modifytime2 */
	private String ModifyTime2;

	public static final int FIELDNUM = 21;	// 数据库表的字段个数

	private static String[] PK;				// 主键

	private FDate fDate = new FDate();		// 处理日期

	public CErrors mErrors;			// 错误信息

	// @Constructor
	public LRTermBSchema()
	{
		mErrors = new CErrors();

		String[] pk = new String[2];
		pk[0] = "EdorNo";
		pk[1] = "Id";

		PK = pk;
	}

	/**
	* Schema克隆
	* @return Object
	* @throws CloneNotSupportedException
	*/
	public Object clone()
		throws CloneNotSupportedException
	{
		LRTermBSchema cloned = (LRTermBSchema)super.clone();
		cloned.fDate = (FDate) fDate.clone();
		cloned.mErrors = (CErrors) mErrors.clone();
		return cloned;
	}

	// @Method
	public String[] getPK()
	{
		return PK;
	}

	/**
	* 流水号
	*/
	public String getEdorNo()
	{
		return EdorNo;
	}
	public void setEdorNo(String aEdorNo)
	{
		if(aEdorNo!=null && aEdorNo.length()>20)
			throw new IllegalArgumentException("EdornoEdorNo值"+aEdorNo+"的长度"+aEdorNo.length()+"大于最大值20");
		EdorNo = aEdorNo;
	}
	/**
	* 词条编码
	*/
	public String getId()
	{
		return Id;
	}
	public void setId(String aId)
	{
		if(aId!=null && aId.length()>20)
			throw new IllegalArgumentException("IdId值"+aId+"的长度"+aId.length()+"大于最大值20");
		Id = aId;
	}
	/**
	* 词条名称
	*/
	public String getName()
	{
		return Name;
	}
	public void setName(String aName)
	{
		if(aName!=null && aName.length()>200)
			throw new IllegalArgumentException("NameName值"+aName+"的长度"+aName.length()+"大于最大值200");
		Name = aName;
	}
	/**
	* BOM编码
	*/
	public String getBomId()
	{
		return BomId;
	}
	public void setBomId(String aBomId)
	{
		if(aBomId!=null && aBomId.length()>20)
			throw new IllegalArgumentException("BomidBomId值"+aBomId+"的长度"+aBomId.length()+"大于最大值20");
		BomId = aBomId;
	}
	/**
	* 备注
	*/
	public String getRemark()
	{
		return Remark;
	}
	public void setRemark(String aRemark)
	{
		if(aRemark!=null && aRemark.length()>500)
			throw new IllegalArgumentException("RemarkRemark值"+aRemark+"的长度"+aRemark.length()+"大于最大值500");
		Remark = aRemark;
	}
	/**
	* 显示顺序
	*/
	public int getDisPlayOrder()
	{
		return DisPlayOrder;
	}
	public void setDisPlayOrder(int aDisPlayOrder)
	{
		DisPlayOrder = aDisPlayOrder;
	}
	public void setDisPlayOrder(String aDisPlayOrder)
	{
		if (aDisPlayOrder != null && !aDisPlayOrder.equals(""))
		{
			Integer tInteger = new Integer(aDisPlayOrder);
			int i = tInteger.intValue();
			DisPlayOrder = i;
		}
	}

	/**
	* 状态
	*/
	public String getState()
	{
		return State;
	}
	public void setState(String aState)
	{
		if(aState!=null && aState.length()>1)
			throw new IllegalArgumentException("StateState值"+aState+"的长度"+aState.length()+"大于最大值1");
		State = aState;
	}
	/**
	* 数据类型
	*/
	public String getDataType()
	{
		return DataType;
	}
	public void setDataType(String aDataType)
	{
		if(aDataType!=null && aDataType.length()>2)
			throw new IllegalArgumentException("DatatypeDataType值"+aDataType+"的长度"+aDataType.length()+"大于最大值2");
		DataType = aDataType;
	}
	/**
	* 计算类型
	*/
	public String getCalType()
	{
		return CalType;
	}
	public void setCalType(String aCalType)
	{
		if(aCalType!=null && aCalType.length()>2)
			throw new IllegalArgumentException("CaltypeCalType值"+aCalType+"的长度"+aCalType.length()+"大于最大值2");
		CalType = aCalType;
	}
	/**
	* 属性
	*/
	public String getAttribute()
	{
		return Attribute;
	}
	public void setAttribute(String aAttribute)
	{
		if(aAttribute!=null && aAttribute.length()>100)
			throw new IllegalArgumentException("AttributeAttribute值"+aAttribute+"的长度"+aAttribute.length()+"大于最大值100");
		Attribute = aAttribute;
	}
	/**
	* 计算SQL
	*/
	public String getCalSql()
	{
		return CalSql;
	}
	public void setCalSql(String aCalSql)
	{
		CalSql = aCalSql;
	}
	/**
	* 操作者
	*/
	public String getOperator()
	{
		return Operator;
	}
	public void setOperator(String aOperator)
	{
		if(aOperator!=null && aOperator.length()>60)
			throw new IllegalArgumentException("OperatorOperator值"+aOperator+"的长度"+aOperator.length()+"大于最大值60");
		Operator = aOperator;
	}
	/**
	* 入机日期
	*/
	public String getMakeDate()
	{
		if( MakeDate != null )
			return fDate.getString(MakeDate);
		else
			return null;
	}
	public void setMakeDate(Date aMakeDate)
	{
		MakeDate = aMakeDate;
	}
	public void setMakeDate(String aMakeDate)
	{
		if (aMakeDate != null && !aMakeDate.equals("") )
		{
			MakeDate = fDate.getDate( aMakeDate );
		}
		else
			MakeDate = null;
	}

	/**
	* 入机时间
	*/
	public String getMakeTime()
	{
		return MakeTime;
	}
	public void setMakeTime(String aMakeTime)
	{
		if(aMakeTime!=null && aMakeTime.length()>8)
			throw new IllegalArgumentException("MaketimeMakeTime值"+aMakeTime+"的长度"+aMakeTime.length()+"大于最大值8");
		MakeTime = aMakeTime;
	}
	/**
	* 最后一次修改日期
	*/
	public String getModifyDate()
	{
		if( ModifyDate != null )
			return fDate.getString(ModifyDate);
		else
			return null;
	}
	public void setModifyDate(Date aModifyDate)
	{
		ModifyDate = aModifyDate;
	}
	public void setModifyDate(String aModifyDate)
	{
		if (aModifyDate != null && !aModifyDate.equals("") )
		{
			ModifyDate = fDate.getDate( aModifyDate );
		}
		else
			ModifyDate = null;
	}

	/**
	* 最后一次修改时间
	*/
	public String getModifyTime()
	{
		return ModifyTime;
	}
	public void setModifyTime(String aModifyTime)
	{
		if(aModifyTime!=null && aModifyTime.length()>8)
			throw new IllegalArgumentException("ModifytimeModifyTime值"+aModifyTime+"的长度"+aModifyTime.length()+"大于最大值8");
		ModifyTime = aModifyTime;
	}
	/**
	* 操作者2
	*/
	public String getOperator2()
	{
		return Operator2;
	}
	public void setOperator2(String aOperator2)
	{
		if(aOperator2!=null && aOperator2.length()>60)
			throw new IllegalArgumentException("Operator2Operator2值"+aOperator2+"的长度"+aOperator2.length()+"大于最大值60");
		Operator2 = aOperator2;
	}
	/**
	* 入机日期2
	*/
	public String getMakeDate2()
	{
		if( MakeDate2 != null )
			return fDate.getString(MakeDate2);
		else
			return null;
	}
	public void setMakeDate2(Date aMakeDate2)
	{
		MakeDate2 = aMakeDate2;
	}
	public void setMakeDate2(String aMakeDate2)
	{
		if (aMakeDate2 != null && !aMakeDate2.equals("") )
		{
			MakeDate2 = fDate.getDate( aMakeDate2 );
		}
		else
			MakeDate2 = null;
	}

	/**
	* 入机时间2
	*/
	public String getMakeTime2()
	{
		return MakeTime2;
	}
	public void setMakeTime2(String aMakeTime2)
	{
		if(aMakeTime2!=null && aMakeTime2.length()>8)
			throw new IllegalArgumentException("Maketime2MakeTime2值"+aMakeTime2+"的长度"+aMakeTime2.length()+"大于最大值8");
		MakeTime2 = aMakeTime2;
	}
	/**
	* 最后一次修改日期2
	*/
	public String getModifyDate2()
	{
		if( ModifyDate2 != null )
			return fDate.getString(ModifyDate2);
		else
			return null;
	}
	public void setModifyDate2(Date aModifyDate2)
	{
		ModifyDate2 = aModifyDate2;
	}
	public void setModifyDate2(String aModifyDate2)
	{
		if (aModifyDate2 != null && !aModifyDate2.equals("") )
		{
			ModifyDate2 = fDate.getDate( aModifyDate2 );
		}
		else
			ModifyDate2 = null;
	}

	/**
	* 最后一次修改时间2
	*/
	public String getModifyTime2()
	{
		return ModifyTime2;
	}
	public void setModifyTime2(String aModifyTime2)
	{
		if(aModifyTime2!=null && aModifyTime2.length()>8)
			throw new IllegalArgumentException("Modifytime2ModifyTime2值"+aModifyTime2+"的长度"+aModifyTime2.length()+"大于最大值8");
		ModifyTime2 = aModifyTime2;
	}

	/**
	* 使用另外一个 LRTermBSchema 对象给 Schema 赋值
	* @param: aLRTermBSchema LRTermBSchema
	**/
	public void setSchema(LRTermBSchema aLRTermBSchema)
	{
		this.EdorNo = aLRTermBSchema.getEdorNo();
		this.Id = aLRTermBSchema.getId();
		this.Name = aLRTermBSchema.getName();
		this.BomId = aLRTermBSchema.getBomId();
		this.Remark = aLRTermBSchema.getRemark();
		this.DisPlayOrder = aLRTermBSchema.getDisPlayOrder();
		this.State = aLRTermBSchema.getState();
		this.DataType = aLRTermBSchema.getDataType();
		this.CalType = aLRTermBSchema.getCalType();
		this.Attribute = aLRTermBSchema.getAttribute();
		this.CalSql = aLRTermBSchema.getCalSql();
		this.Operator = aLRTermBSchema.getOperator();
		this.MakeDate = fDate.getDate( aLRTermBSchema.getMakeDate());
		this.MakeTime = aLRTermBSchema.getMakeTime();
		this.ModifyDate = fDate.getDate( aLRTermBSchema.getModifyDate());
		this.ModifyTime = aLRTermBSchema.getModifyTime();
		this.Operator2 = aLRTermBSchema.getOperator2();
		this.MakeDate2 = fDate.getDate( aLRTermBSchema.getMakeDate2());
		this.MakeTime2 = aLRTermBSchema.getMakeTime2();
		this.ModifyDate2 = fDate.getDate( aLRTermBSchema.getModifyDate2());
		this.ModifyTime2 = aLRTermBSchema.getModifyTime2();
	}

	/**
	* 使用 ResultSet 中的第 i 行给 Schema 赋值
	* @param: rs ResultSet
	* @param: i int
	* @return: boolean
	**/
	public boolean setSchema(ResultSet rs,int i)
	{
		try
		{
			//rs.absolute(i);		// 非滚动游标
			if( rs.getString("EdorNo") == null )
				this.EdorNo = null;
			else
				this.EdorNo = rs.getString("EdorNo").trim();

			if( rs.getString("Id") == null )
				this.Id = null;
			else
				this.Id = rs.getString("Id").trim();

			if( rs.getString("Name") == null )
				this.Name = null;
			else
				this.Name = rs.getString("Name").trim();

			if( rs.getString("BomId") == null )
				this.BomId = null;
			else
				this.BomId = rs.getString("BomId").trim();

			if( rs.getString("Remark") == null )
				this.Remark = null;
			else
				this.Remark = rs.getString("Remark").trim();

			this.DisPlayOrder = rs.getInt("DisPlayOrder");
			if( rs.getString("State") == null )
				this.State = null;
			else
				this.State = rs.getString("State").trim();

			if( rs.getString("DataType") == null )
				this.DataType = null;
			else
				this.DataType = rs.getString("DataType").trim();

			if( rs.getString("CalType") == null )
				this.CalType = null;
			else
				this.CalType = rs.getString("CalType").trim();

			if( rs.getString("Attribute") == null )
				this.Attribute = null;
			else
				this.Attribute = rs.getString("Attribute").trim();

			if( rs.getString("CalSql") == null )
				this.CalSql = null;
			else
				this.CalSql = rs.getString("CalSql").trim();

			if( rs.getString("Operator") == null )
				this.Operator = null;
			else
				this.Operator = rs.getString("Operator").trim();

			this.MakeDate = rs.getDate("MakeDate");
			if( rs.getString("MakeTime") == null )
				this.MakeTime = null;
			else
				this.MakeTime = rs.getString("MakeTime").trim();

			this.ModifyDate = rs.getDate("ModifyDate");
			if( rs.getString("ModifyTime") == null )
				this.ModifyTime = null;
			else
				this.ModifyTime = rs.getString("ModifyTime").trim();

			if( rs.getString("Operator2") == null )
				this.Operator2 = null;
			else
				this.Operator2 = rs.getString("Operator2").trim();

			this.MakeDate2 = rs.getDate("MakeDate2");
			if( rs.getString("MakeTime2") == null )
				this.MakeTime2 = null;
			else
				this.MakeTime2 = rs.getString("MakeTime2").trim();

			this.ModifyDate2 = rs.getDate("ModifyDate2");
			if( rs.getString("ModifyTime2") == null )
				this.ModifyTime2 = null;
			else
				this.ModifyTime2 = rs.getString("ModifyTime2").trim();

		}
		catch(SQLException sqle)
		{
			logger.debug("数据库中的LRTermB表字段个数和Schema中的字段个数不一致，或者执行db.executeQuery查询时没有使用select * from tables");
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRTermBSchema";
			tError.functionName = "setSchema";
			tError.errorMessage = sqle.toString();
			this.mErrors .addOneError(tError);
			return false;
		}
		return true;
	}

	public LRTermBSchema getSchema()
	{
		LRTermBSchema aLRTermBSchema = new LRTermBSchema();
		aLRTermBSchema.setSchema(this);
		return aLRTermBSchema;
	}

	public LRTermBDB getDB()
	{
		LRTermBDB aDBOper = new LRTermBDB();
		aDBOper.setSchema(this);
		return aDBOper;
	}


	/**
	* 数据打包，按 XML 格式打包，顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRTermB描述/A>表字段
	* @return: String 返回打包后字符串
	**/
	public String encode()
	{
		StringBuffer strReturn = new StringBuffer(256);
		strReturn.append(StrTool.cTrim(EdorNo)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Id)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Name)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(BomId)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Remark)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append( ChgData.chgData(DisPlayOrder));strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(State)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(DataType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalType)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Attribute)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(CalSql)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(Operator2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( MakeDate2 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(MakeTime2)); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(fDate.getString( ModifyDate2 ))); strReturn.append(SysConst.PACKAGESPILTER);
		strReturn.append(StrTool.cTrim(ModifyTime2));
		return strReturn.toString();
	}

	/**
	* 数据解包，解包顺序参见<A href ={@docRoot}/dataStructure/tb.html#PrpLRTermB>历史记账凭证主表信息</A>表字段
	* @param: strMessage String 包含一条纪录数据的字符串
	* @return: boolean
	**/
	public boolean decode(String strMessage)
	{
		try
		{
			EdorNo = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 1, SysConst.PACKAGESPILTER );
			Id = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 2, SysConst.PACKAGESPILTER );
			Name = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 3, SysConst.PACKAGESPILTER );
			BomId = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 4, SysConst.PACKAGESPILTER );
			Remark = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 5, SysConst.PACKAGESPILTER );
			DisPlayOrder= new Integer(ChgData.chgNumericStr(StrTool.getStr(strMessage,6,SysConst.PACKAGESPILTER))).intValue();
			State = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 7, SysConst.PACKAGESPILTER );
			DataType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 8, SysConst.PACKAGESPILTER );
			CalType = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 9, SysConst.PACKAGESPILTER );
			Attribute = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 10, SysConst.PACKAGESPILTER );
			CalSql = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 11, SysConst.PACKAGESPILTER );
			Operator = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 12, SysConst.PACKAGESPILTER );
			MakeDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 13,SysConst.PACKAGESPILTER));
			MakeTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 14, SysConst.PACKAGESPILTER );
			ModifyDate = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 15,SysConst.PACKAGESPILTER));
			ModifyTime = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 16, SysConst.PACKAGESPILTER );
			Operator2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 17, SysConst.PACKAGESPILTER );
			MakeDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 18,SysConst.PACKAGESPILTER));
			MakeTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 19, SysConst.PACKAGESPILTER );
			ModifyDate2 = fDate.getDate(StrTool.getStr(StrTool.GBKToUnicode(strMessage), 20,SysConst.PACKAGESPILTER));
			ModifyTime2 = StrTool.getStr(StrTool.GBKToUnicode(strMessage), 21, SysConst.PACKAGESPILTER );
		}
		catch(NumberFormatException ex)
		{
			// @@错误处理
			CError tError = new CError();
			tError.moduleName = "LRTermBSchema";
			tError.functionName = "decode";
			tError.errorMessage = ex.toString();
			this.mErrors .addOneError(tError);

			return false;
		}
		return true;
	}

	/**
	* 取得对应传入参数的String形式的字段值
	* @param: FCode String 希望取得的字段名
	* @return: String
	* 如果没有对应的字段，返回""
	* 如果字段值为空，返回"null"
	**/
	public String getV(String FCode)
	{
		String strReturn = "";
		if (FCode.equalsIgnoreCase("EdorNo"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(EdorNo));
		}
		if (FCode.equalsIgnoreCase("Id"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Id));
		}
		if (FCode.equalsIgnoreCase("Name"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Name));
		}
		if (FCode.equalsIgnoreCase("BomId"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(BomId));
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Remark));
		}
		if (FCode.equalsIgnoreCase("DisPlayOrder"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DisPlayOrder));
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(State));
		}
		if (FCode.equalsIgnoreCase("DataType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(DataType));
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalType));
		}
		if (FCode.equalsIgnoreCase("Attribute"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Attribute));
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(CalSql));
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator));
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime));
		}
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime));
		}
		if (FCode.equalsIgnoreCase("Operator2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(Operator2));
		}
		if (FCode.equalsIgnoreCase("MakeDate2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate2()));
		}
		if (FCode.equalsIgnoreCase("MakeTime2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(MakeTime2));
		}
		if (FCode.equalsIgnoreCase("ModifyDate2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate2()));
		}
		if (FCode.equalsIgnoreCase("ModifyTime2"))
		{
			strReturn = StrTool.GBKToUnicode(String.valueOf(ModifyTime2));
		}
		if (strReturn.equals(""))
		{
			strReturn = "null";
		}

		return strReturn;
	}


	/**
	* 取得Schema中指定索引值所对应的字段值
	* @param: nFieldIndex int 指定的字段索引值
	* @return: String
	* 如果没有对应的字段，返回""
	* 如果字段值为空，返回"null"
	**/
	public String getV(int nFieldIndex)
	{
		String strFieldValue = "";
		switch(nFieldIndex) {
			case 0:
				strFieldValue = StrTool.GBKToUnicode(EdorNo);
				break;
			case 1:
				strFieldValue = StrTool.GBKToUnicode(Id);
				break;
			case 2:
				strFieldValue = StrTool.GBKToUnicode(Name);
				break;
			case 3:
				strFieldValue = StrTool.GBKToUnicode(BomId);
				break;
			case 4:
				strFieldValue = StrTool.GBKToUnicode(Remark);
				break;
			case 5:
				strFieldValue = String.valueOf(DisPlayOrder);
				break;
			case 6:
				strFieldValue = StrTool.GBKToUnicode(State);
				break;
			case 7:
				strFieldValue = StrTool.GBKToUnicode(DataType);
				break;
			case 8:
				strFieldValue = StrTool.GBKToUnicode(CalType);
				break;
			case 9:
				strFieldValue = StrTool.GBKToUnicode(Attribute);
				break;
			case 10:
				strFieldValue = StrTool.GBKToUnicode(CalSql);
				break;
			case 11:
				strFieldValue = StrTool.GBKToUnicode(Operator);
				break;
			case 12:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate()));
				break;
			case 13:
				strFieldValue = StrTool.GBKToUnicode(MakeTime);
				break;
			case 14:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate()));
				break;
			case 15:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime);
				break;
			case 16:
				strFieldValue = StrTool.GBKToUnicode(Operator2);
				break;
			case 17:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getMakeDate2()));
				break;
			case 18:
				strFieldValue = StrTool.GBKToUnicode(MakeTime2);
				break;
			case 19:
				strFieldValue = StrTool.GBKToUnicode(String.valueOf( this.getModifyDate2()));
				break;
			case 20:
				strFieldValue = StrTool.GBKToUnicode(ModifyTime2);
				break;
			default:
				strFieldValue = "";
		};
		if( strFieldValue.equals("") ) {
			strFieldValue = "null";
		}
		return strFieldValue;
	}

	/**
	* 设置对应传入参数的String形式的字段值
	* @param: FCode String 需要赋值的对象
	* @param: FValue String 要赋的值
	* @return: boolean
	**/
	public boolean setV(String FCode ,String FValue)
	{
		if( StrTool.cTrim( FCode ).equals( "" ))
			return false;

		if (FCode.equalsIgnoreCase("EdorNo"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				EdorNo = FValue.trim();
			}
			else
				EdorNo = null;
		}
		if (FCode.equalsIgnoreCase("Id"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Id = FValue.trim();
			}
			else
				Id = null;
		}
		if (FCode.equalsIgnoreCase("Name"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Name = FValue.trim();
			}
			else
				Name = null;
		}
		if (FCode.equalsIgnoreCase("BomId"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				BomId = FValue.trim();
			}
			else
				BomId = null;
		}
		if (FCode.equalsIgnoreCase("Remark"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Remark = FValue.trim();
			}
			else
				Remark = null;
		}
		if (FCode.equalsIgnoreCase("DisPlayOrder"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Integer tInteger = new Integer( FValue );
				int i = tInteger.intValue();
				DisPlayOrder = i;
			}
		}
		if (FCode.equalsIgnoreCase("State"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				State = FValue.trim();
			}
			else
				State = null;
		}
		if (FCode.equalsIgnoreCase("DataType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				DataType = FValue.trim();
			}
			else
				DataType = null;
		}
		if (FCode.equalsIgnoreCase("CalType"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalType = FValue.trim();
			}
			else
				CalType = null;
		}
		if (FCode.equalsIgnoreCase("Attribute"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Attribute = FValue.trim();
			}
			else
				Attribute = null;
		}
		if (FCode.equalsIgnoreCase("CalSql"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				CalSql = FValue.trim();
			}
			else
				CalSql = null;
		}
		if (FCode.equalsIgnoreCase("Operator"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator = FValue.trim();
			}
			else
				Operator = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate = fDate.getDate( FValue );
			}
			else
				MakeDate = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime = FValue.trim();
			}
			else
				MakeTime = null;
		}
		if (FCode.equalsIgnoreCase("ModifyDate"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ModifyDate = fDate.getDate( FValue );
			}
			else
				ModifyDate = null;
		}
		if (FCode.equalsIgnoreCase("ModifyTime"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyTime = FValue.trim();
			}
			else
				ModifyTime = null;
		}
		if (FCode.equalsIgnoreCase("Operator2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				Operator2 = FValue.trim();
			}
			else
				Operator2 = null;
		}
		if (FCode.equalsIgnoreCase("MakeDate2"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				MakeDate2 = fDate.getDate( FValue );
			}
			else
				MakeDate2 = null;
		}
		if (FCode.equalsIgnoreCase("MakeTime2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				MakeTime2 = FValue.trim();
			}
			else
				MakeTime2 = null;
		}
		if (FCode.equalsIgnoreCase("ModifyDate2"))
		{
			if( FValue != null && !FValue.equals("") )
			{
				ModifyDate2 = fDate.getDate( FValue );
			}
			else
				ModifyDate2 = null;
		}
		if (FCode.equalsIgnoreCase("ModifyTime2"))
		{
			if( FValue != null && !FValue.equals(""))
			{
				ModifyTime2 = FValue.trim();
			}
			else
				ModifyTime2 = null;
		}
		return true;
	}

	public boolean equals(Object otherObject)
	{
		if (this == otherObject) return true;
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass()) return false;
		LRTermBSchema other = (LRTermBSchema)otherObject;
		return
			EdorNo.equals(other.getEdorNo())
			&& Id.equals(other.getId())
			&& Name.equals(other.getName())
			&& BomId.equals(other.getBomId())
			&& Remark.equals(other.getRemark())
			&& DisPlayOrder == other.getDisPlayOrder()
			&& State.equals(other.getState())
			&& DataType.equals(other.getDataType())
			&& CalType.equals(other.getCalType())
			&& Attribute.equals(other.getAttribute())
			&& CalSql.equals(other.getCalSql())
			&& Operator.equals(other.getOperator())
			&& fDate.getString(MakeDate).equals(other.getMakeDate())
			&& MakeTime.equals(other.getMakeTime())
			&& fDate.getString(ModifyDate).equals(other.getModifyDate())
			&& ModifyTime.equals(other.getModifyTime())
			&& Operator2.equals(other.getOperator2())
			&& fDate.getString(MakeDate2).equals(other.getMakeDate2())
			&& MakeTime2.equals(other.getMakeTime2())
			&& fDate.getString(ModifyDate2).equals(other.getModifyDate2())
			&& ModifyTime2.equals(other.getModifyTime2());
	}

	/**
	* 取得Schema拥有字段的数量
       * @return: int
	**/
	public int getFieldCount()
	{
 		return FIELDNUM;
	}

	/**
	* 取得Schema中指定字段名所对应的索引值
	* 如果没有对应的字段，返回-1
       * @param: strFieldName String
       * @return: int
	**/
	public int getFieldIndex(String strFieldName)
	{
		if( strFieldName.equals("EdorNo") ) {
			return 0;
		}
		if( strFieldName.equals("Id") ) {
			return 1;
		}
		if( strFieldName.equals("Name") ) {
			return 2;
		}
		if( strFieldName.equals("BomId") ) {
			return 3;
		}
		if( strFieldName.equals("Remark") ) {
			return 4;
		}
		if( strFieldName.equals("DisPlayOrder") ) {
			return 5;
		}
		if( strFieldName.equals("State") ) {
			return 6;
		}
		if( strFieldName.equals("DataType") ) {
			return 7;
		}
		if( strFieldName.equals("CalType") ) {
			return 8;
		}
		if( strFieldName.equals("Attribute") ) {
			return 9;
		}
		if( strFieldName.equals("CalSql") ) {
			return 10;
		}
		if( strFieldName.equals("Operator") ) {
			return 11;
		}
		if( strFieldName.equals("MakeDate") ) {
			return 12;
		}
		if( strFieldName.equals("MakeTime") ) {
			return 13;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return 14;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return 15;
		}
		if( strFieldName.equals("Operator2") ) {
			return 16;
		}
		if( strFieldName.equals("MakeDate2") ) {
			return 17;
		}
		if( strFieldName.equals("MakeTime2") ) {
			return 18;
		}
		if( strFieldName.equals("ModifyDate2") ) {
			return 19;
		}
		if( strFieldName.equals("ModifyTime2") ) {
			return 20;
		}
		return -1;
	}

	/**
	* 取得Schema中指定索引值所对应的字段名
	* 如果没有对应的字段，返回""
       * @param: nFieldIndex int
       * @return: String
	**/
	public String getFieldName(int nFieldIndex)
	{
		String strFieldName = "";
		switch(nFieldIndex) {
			case 0:
				strFieldName = "EdorNo";
				break;
			case 1:
				strFieldName = "Id";
				break;
			case 2:
				strFieldName = "Name";
				break;
			case 3:
				strFieldName = "BomId";
				break;
			case 4:
				strFieldName = "Remark";
				break;
			case 5:
				strFieldName = "DisPlayOrder";
				break;
			case 6:
				strFieldName = "State";
				break;
			case 7:
				strFieldName = "DataType";
				break;
			case 8:
				strFieldName = "CalType";
				break;
			case 9:
				strFieldName = "Attribute";
				break;
			case 10:
				strFieldName = "CalSql";
				break;
			case 11:
				strFieldName = "Operator";
				break;
			case 12:
				strFieldName = "MakeDate";
				break;
			case 13:
				strFieldName = "MakeTime";
				break;
			case 14:
				strFieldName = "ModifyDate";
				break;
			case 15:
				strFieldName = "ModifyTime";
				break;
			case 16:
				strFieldName = "Operator2";
				break;
			case 17:
				strFieldName = "MakeDate2";
				break;
			case 18:
				strFieldName = "MakeTime2";
				break;
			case 19:
				strFieldName = "ModifyDate2";
				break;
			case 20:
				strFieldName = "ModifyTime2";
				break;
			default:
				strFieldName = "";
		};
		return strFieldName;
	}

	/**
	* 取得Schema中指定字段名所对应的字段类型
	* 如果没有对应的字段，返回Schema.TYPE_NOFOUND
       * @param: strFieldName String
       * @return: int
	**/
	public int getFieldType(String strFieldName)
	{
		if( strFieldName.equals("EdorNo") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Id") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Name") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("BomId") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Remark") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DisPlayOrder") ) {
			return Schema.TYPE_INT;
		}
		if( strFieldName.equals("State") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("DataType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalType") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Attribute") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("CalSql") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyDate") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ModifyTime") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("Operator2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("MakeDate2") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("MakeTime2") ) {
			return Schema.TYPE_STRING;
		}
		if( strFieldName.equals("ModifyDate2") ) {
			return Schema.TYPE_DATE;
		}
		if( strFieldName.equals("ModifyTime2") ) {
			return Schema.TYPE_STRING;
		}
		return Schema.TYPE_NOFOUND;
	}

	/**
	* 取得Schema中指定索引值所对应的字段类型
	* 如果没有对应的字段，返回Schema.TYPE_NOFOUND
       * @param: nFieldIndex int
       * @return: int
	**/
	public int getFieldType(int nFieldIndex)
	{
		int nFieldType = Schema.TYPE_NOFOUND;
		switch(nFieldIndex) {
			case 0:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 1:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 2:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 3:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 4:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 5:
				nFieldType = Schema.TYPE_INT;
				break;
			case 6:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 7:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 8:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 9:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 10:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 11:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 12:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 13:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 14:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 15:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 16:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 17:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 18:
				nFieldType = Schema.TYPE_STRING;
				break;
			case 19:
				nFieldType = Schema.TYPE_DATE;
				break;
			case 20:
				nFieldType = Schema.TYPE_STRING;
				break;
			default:
				nFieldType = Schema.TYPE_NOFOUND;
		};
		return nFieldType;
	}
}
