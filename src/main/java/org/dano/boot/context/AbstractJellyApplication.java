package org.dano.boot.context;

/**
 * @author dongxiaohong
 * @date 2018/12/10 11:34
 */
public abstract class AbstractJellyApplication implements JellyApplication {

    /**
     * 上下文的模板方法
     * */
    public void refresh(){
        /**prepareRefresh() 1.加入控制参数标志准备刷新*/

        /** ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory()
         * 2.获取BeanFactory,以及BeanFactory是否刷新,也就是每次创建时新生成与否
         * GenericApplicationContext不支持容器刷新
         * */

        /**3.prepareBeanFactory(beanFactory) BeanFactory准备,配置Factory的一些属性,比如:
         *  设置ClassLoader
         *  设置资源编辑器
         *  设置特殊依赖类型
         *  设置BeanFactoryPostProcessor等等,这些BeanFactoryPostProcessor一般会首先执行
         * */

        /**4.postProcessBeanFactory(beanFactory) 允许在执行BeanFactoryPostProcessor的postBeanFactory对factory进行预操作,一般不去修改父类方法*/

        /**5.invokeBeanFactoryPostProcessors(beanFactory) 调用BeanFactoryPostProcessor的postBeanFactory*/

        /**
         * 6.registerBeanPostProcessors(beanFactory) BeanFactory处理完了,接下来处理的是Bean实例,也就是找到BeanPostProcessor
         * 一般说来,手动add的BeanPostProcessor得执行顺序最靠前,
         * 然后是实现了PriorityOrdered接口的BeanPostProcessor,
         * 紧接着是继承了Ordered接口的BeanPostProcessor,
         * 最后是什么都没有继承的BeanPostProcessor
         * 把这些BeanPostProcessor加到BeanFactory的beanPostProcessors中去,当有一个是instantiationBeanPostProcessor时,hasInstantiationBeanPost=true
         * */

        /**7.initMessageSource() 国际化,国际化是第七步,比较单一的一步*/
        /**8.initApplicationEventMulticaster() 事件广播*/
        /**9.initLifecycleDependentBeans() 初始化声明周期依赖的Beans*/
        /**10.onRefresh()() 其他Context的特殊bean初始化*/
        /**11.registerListeners()() 注册监听器*/

        /**
         * 12.finishBeanFactoryInitialization(beanFactory) 加载非懒加载的bean,分为两类
         * 如果不是抽象类,并且是单例而且不是懒加载而是eager(及时)加载则:
         * 1.如果是FactoryBean则要在beanName前加一个&来获取bean
         * 2.如果不是FactoryBean则直接按BeanName来获取
         * 这个地方会遍历所有注册的BeanNames,从beanDefinitionNames中获取name
         * if (this.logger.isInfoEnabled()) {
         * 			this.logger.info("Pre-instantiating singletons in " + this);
         *                }
         *
         * 		synchronized (this.beanDefinitionMap) {
         * 			for (Iterator it = this.beanDefinitionNames.iterator(); it.hasNext();) {
         * 				String beanName = (String) it.next();
         * 				RootBeanDefinition bd = getMergedLocalBeanDefinition(beanName);
         * 				if (!bd.isAbstract() && bd.isSingleton() && !bd.isLazyInit()) {
         * 					if (isFactoryBean(beanName)) {
         * 						FactoryBean factory = (FactoryBean) getBean(FACTORY_BEAN_PREFIX + beanName);
         * 						if (factory instanceof SmartFactoryBean && ((SmartFactoryBean) factory).isEagerInit()) {
         * 							getBean(beanName);
         *                        }
         *                    }
         * 					else {
         * 						getBean(beanName);
         *                    }
         *                }
         *            }
         *        }
         * 默认情况下,很多实例都满足这个条件,所以说Application是一开始就把所有的bean获取一遍
         * */
        /**13.finishRefresh()完成刷新,发布事件*/
    }
}
