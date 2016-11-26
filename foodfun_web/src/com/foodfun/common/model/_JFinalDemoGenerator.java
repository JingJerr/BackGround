package com.foodfun.common.model;

import javax.sql.DataSource;
import com.foodfun.common.config.FoodfunConfig;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * �����ݿ�����κα䶯ʱ������һ�� main ������������Ӧ�仯���д����ع�
 */
public class _JFinalDemoGenerator {
	
	public static DataSource getDataSource() {
		PropKit.use("a_little_config.txt");
		C3p0Plugin c3p0Plugin = FoodfunConfig.createC3p0Plugin();
		c3p0Plugin.start();
		return c3p0Plugin.getDataSource();
	}
	
	public static void main(String[] args) {
		// base model ��ʹ�õİ���
		String baseModelPackageName = "com.foodfun.common.model.base";
		// base model �ļ�����·��
		String baseModelOutputDir = PathKit.getWebRootPath() + "/../src/com/foodfun/common/model/base";
		
		// model ��ʹ�õİ��� (MappingKit Ĭ��ʹ�õİ���)
		String modelPackageName = "com.foodfun.common.model";
		// model �ļ�����·�� (MappingKit �� DataDictionary �ļ�Ĭ�ϱ���·��)
		String modelOutputDir = baseModelOutputDir + "/..";
		
		// ����������
		Generator gernerator = new Generator(getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);
		// ��Ӳ���Ҫ���ɵı���
		gernerator.addExcludedTable("adv");
		// �����Ƿ��� Model ������ dao ����
		gernerator.setGenerateDaoInModel(true);
		// �����Ƿ������ֵ��ļ�
		gernerator.setGenerateDataDictionary(false);
		// ������Ҫ���Ƴ��ı���ǰ׺��������modelName��������� "osc_user"���Ƴ�ǰ׺ "osc_"�����ɵ�model��Ϊ "User"���� OscUser
		gernerator.setRemovedTableNamePrefixes("t_");
		// ����
		gernerator.generate();
	}
}




