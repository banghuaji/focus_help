package com.help.autotest.common;

public enum ElemVariety {

	/** 输入框 */
	input(1),

	/** 下拉框 */
	select(4),

	/** 单选框 */
	radio(5),

	/** 多选框 */
	checkbox(6),

	/** 链接 */
	link(7),

	/** 按钮 */
	button(8),

	/** 其他 */
	other(9),

	/** 图片 */
	image(10),

	/** 表格 */
	form(11),

	/** 列表 */
	list (12),

	/** 富文本 */
	textarea(13),

	/** 文本 */
	text(14)

	;

	private int value;

	public int getValue() {
		return value;
	}

	ElemVariety(int value) {
		this.value = value;
	}


	public static ElemVariety getByValue(int value) {
		ElemVariety[] browsers = ElemVariety.values();
		if (browsers != null && browsers.length > 0) {
			for (ElemVariety t : browsers) {
				if (t.getValue() == value) {
					return t;
				}
			}
		}
		return null;
	}
	public static String getStringValue(int value) {
		ElemVariety[] browsers = ElemVariety.values();
		if (browsers != null && browsers.length > 0) {
			for (ElemVariety t : browsers) {
				if (t.getValue() == value) {
					return "ElemVariety."+t.name();
				}
			}
		}
		return null;
	}

}
