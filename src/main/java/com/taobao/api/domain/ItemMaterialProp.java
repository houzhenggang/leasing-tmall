package com.taobao.api.domain;

import com.taobao.api.TaobaoObject;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

import java.util.List;


/**
 * 材质属性数据结构
 *
 * @author top auto create
 * @since 1.0, null
 */
public class ItemMaterialProp extends TaobaoObject {

	private static final long serialVersionUID = 4262681417776796452L;

	/**
	 * 材质值列表
	 */
	@ApiListField("materials")
	@ApiField("item_materia_value_d_o")
	private List<ItemMateriaValueDO> materials;


	public List<ItemMateriaValueDO> getMaterials() {
		return this.materials;
	}
	public void setMaterials(List<ItemMateriaValueDO> materials) {
		this.materials = materials;
	}

}
