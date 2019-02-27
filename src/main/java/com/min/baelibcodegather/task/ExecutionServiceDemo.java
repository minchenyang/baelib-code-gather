package com.min.baelibcodegather.task;

/**
 * 任务执行服务涉及接口:
 *  Runnable 和 Callable 表示执行的异步任务
 *  Executor 和 ExecutorService 表示执行服务
 *  Future 表示异步任务的结果
 *
 *  使用者，只需要通过ExecutorService提交任务，通过Future操作任务结果
 *
 *  线程池：
 *      任务执行服务的主要实现机制是线程池，实现类是 ThreadExecutorPool
 *      一: 任务队列
 *      二: 工作者线程
 *
 */
public class ExecutionServiceDemo {

}
