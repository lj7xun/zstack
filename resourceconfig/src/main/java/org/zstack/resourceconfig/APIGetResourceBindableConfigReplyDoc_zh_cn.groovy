package org.zstack.resourceconfig

import org.zstack.header.errorcode.ErrorCode
import org.zstack.resourceconfig.APIGetResourceBindableConfigReply.ResourceBindableConfigStruct

doc {

	title "罗列可配置的资源高级设置的结果"

	ref {
		name "error"
		path "org.zstack.resourceconfig.APIGetResourceBindableConfigReply.error"
		desc "错误码，若不为null，则表示操作失败, 操作成功时该字段为null",false
		type "ErrorCode"
		since "3.4.0"
		clz ErrorCode.class
	}
	ref {
		name "bindableConfigs"
		path "org.zstack.resourceconfig.APIGetResourceBindableConfigReply.bindableConfigs"
		desc "可配置的资源高级设置列表"
		type "List"
		since "3.4.0"
		clz ResourceBindableConfigStruct.class
	}
}
