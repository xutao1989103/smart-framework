package com.xtao.framework.utils;

import com.xtao.smart.utils.copier.CommonEntityCopier;
import com.xtao.smart.utils.copier.EnvEntityCopier;
import com.xtao.smart.utils.copier.Student;
import com.xtao.smart.utils.copier.Worker;
import com.xtao.smart.utils.mapper.EntityMapper;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 * @author xutao
 * @email xt111024@alibaba-inc.com
 * @create 2016-10-29 下午10:30
 */

public class BeanMapperTest extends TestCase {

    public void testCopier() {
        Student student = Student.getDefaultInstance();
        Worker worker = new EntityMapper<Student, Worker>(Student.class, Worker.class).map(student);
        Worker beanCopierWorker = EnvEntityCopier.copy(student);
        Worker commonBeanCopierWorker = CommonEntityCopier.copy(Student.class, Worker.class, student);
        System.out.println(beanCopierWorker.toString());
        System.out.println(commonBeanCopierWorker.toString());
        Assert.assertNotNull(worker);
    }
}
