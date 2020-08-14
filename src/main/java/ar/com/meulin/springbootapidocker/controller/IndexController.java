package ar.com.meulin.springbootapidocker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Instant;

@Controller
public class IndexController {

    @GetMapping({"", "/", "/index", "/home"})
    public String index(Model model) {

        model.addAttribute("titulo", "Springboot WebApp");

        InetAddress host = null;
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        model.addAttribute("hostname", host.getHostName());
        model.addAttribute("ip", host.getHostAddress());
        model.addAttribute("canonical", host.getCanonicalHostName());
        model.addAttribute("hora", Instant.now().toString());

        model.addAttribute("file", System.getProperty("file.separator")); // Character that separates components of a file path. This is "/" on UNIX and "\" on Windows.
        model.addAttribute("javaclasspath", System.getProperty("java.class.path")); // Path used to find directories and JAR archives containing class files. Elements of the class path are separated by a platform-specific character specified in the path.separator property.
        model.addAttribute("javahome", System.getProperty("java.home")); // Installation directory for Java Runtime Environment (JRE)
        model.addAttribute("javavendor", System.getProperty("java.vendor")); // JRE vendor name
        model.addAttribute("javavendorurl", System.getProperty("java.vendor.url")); // JRE vendor URL
        model.addAttribute("javaversion", System.getProperty("java.version")); // JRE version number
        model.addAttribute("lineseparator", System.getProperty("line.separator")); // Sequence used by operating system to separate lines in text files
        model.addAttribute("osarch", System.getProperty("os.arch")); // Operating system architecture
        model.addAttribute("osname", System.getProperty("os.name")); // Operating system name
        model.addAttribute("osversion", System.getProperty("os.version")); // Operating system version
        model.addAttribute("pathseparator", System.getProperty("path.separator")); // Path separator character used in java.class.path
        model.addAttribute("userdir", System.getProperty("user.dir")); // User working directory
        model.addAttribute("userhome", System.getProperty("user.home")); // User home directory
        model.addAttribute("username", System.getProperty("user.name")); // User account name

        return "index";
    }
}
