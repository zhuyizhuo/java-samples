package com.zhuyizhuo.example.maven.plugin.doc;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * maven 插件
 *
 * @author zhuo <br>
 */
@Mojo(name = "doc")
public class DocPlugin extends AbstractMojo {
    @Parameter
    private String targetFile;
    @Parameter
    private String host;
    @Parameter
    private String basePackage;
    @Parameter
    private String classPath;
    @Parameter
    private String libDir;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        this.getLog().info("================ this is zhuo's doc plugin ======================");
        this.getLog().info("params:");
        this.getLog().info("targetFile=" + targetFile);
        this.getLog().info("host=" + host);
        this.getLog().info("basePackage=" + basePackage);
        this.getLog().info("classPath=" + classPath);
        this.getLog().info("libDir=" + libDir);

    }
}
