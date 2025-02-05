<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">

</head>
<body>

  <h1>Composite Design Pattern</h1>

  <p>
    The <strong>Composite Pattern</strong> is a <em>structural design pattern</em> that allows you to compose objects into tree-like structures to represent part-whole hierarchies. 
    The key idea is to treat individual objects (leaves) and compositions (containers of leaves or other composites) uniformly, meaning that both can be used in the same way through a common interface.
  </p>

  <hr>

<h2>Key Intent</h2>
  <ul>
    <li>Define a class hierarchy of simple (leaf) and complex (composite) objects so that they can be treated uniformly through a common interface.</li>
    <li>Enable clients to ignore the difference between compositions of objects and individual objects.</li>
  </ul>

  <hr>

<h2>When to Use</h2>
  <ul>
    <li>You want to represent part-whole hierarchies of objects (e.g., a folder-tree structure in a file system).</li>
    <li>You want clients to treat individual objects and compositions uniformly.</li>
    <li>Complex structures benefit from an interface that simplifies client interaction.</li>
  </ul>

  <hr>

<h2>Participants</h2>
  <ul>
    <li><strong>Component</strong>: An interface or abstract class that declares common operations for both leaves and composites.</li>
    <li><strong>Leaf</strong>: Represents an end object in the structure. A leaf has no children.</li>
    <li><strong>Composite</strong>: Holds children (which can be leaves or composites). Implements operations to manipulate and iterate over children.</li>
    <li><strong>Client</strong>: Interacts with objects through the component interface.</li>
  </ul>

  <hr>

<h2>Structure</h2>
  <p>A UML-like representation of the Composite pattern might look like this:</p>
  <pre>
  +----------------+           +------------------+
  |   Component    |           |    Client        |
  +----------------+           +------------------+
  | + operation()  | <--------|  interacts via   |
  +----------------+           |   Component      |
       ^    ^
       |    |
       |    +----------------------------------------------+
       |                                                   |
       v                                                   v
  +------------+                                +-----------------+
  |    Leaf    |                                |    Composite   |
  +------------+                                +-----------------+
  | + operation()                               | + operation()   |
  |   (leaf-specific
  |   behavior)                                 | + add(Component)|
  |                                             | + remove(Component) |
  +------------+                                +-----------------+
  </pre>

  <hr>

<h2>Example (Java)</h2>
  <p>Below is a simplified Java example showing how the Composite pattern might be implemented.</p>

  <pre><code>
// Component interface
public interface Graphic {
    void draw();
}

// Leaf class
public class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Another Leaf class
public class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Composite class
import java.util.ArrayList;
import java.util.List;

public class Drawing implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic g) {
        graphics.add(g);
    }

    public void remove(Graphic g) {
        graphics.remove(g);
    }

    @Override
    public void draw() {
        for (Graphic g : graphics) {
            g.draw();
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Create some leaf objects
        Graphic circle1 = new Circle();
        Graphic circle2 = new Circle();
        Graphic square1 = new Square();

        // Create a composite and add leaves
        Drawing mainDrawing = new Drawing();
        mainDrawing.add(circle1);
        mainDrawing.add(square1);

        // Create another composite and add leaf
        Drawing subDrawing = new Drawing();
        subDrawing.add(circle2);

        // Add the subDrawing to the mainDrawing
        mainDrawing.add(subDrawing);

        // Draw all
        mainDrawing.draw();
    }
}
  </code></pre>

  <p>
    In this example:
    <ul>
      <li>
        <strong>Graphic</strong> is the <em>Component</em> interface that declares the common operation (<code>draw()</code>) for both simple and complex objects.
      </li>
      <li>
        <strong>Circle</strong> and <strong>Square</strong> are <em>Leaf</em> classes since they implement the operation (<code>draw()</code>) but do not contain other components.
      </li>
      <li>
        <strong>Drawing</strong> is a <em>Composite</em> class that can hold and manage child components in a list, 
        and when its <code>draw()</code> method is called, it delegates the call to all child components.
      </li>
      <li>
        <strong>Client</strong> treats individual <code>Graphic</code> objects and <code>Drawing</code> objects (composites) uniformly via the <code>Graphic</code> interface.
      </li>
    </ul>
  </p>

  <hr>

<h2>Benefits</h2>
  <ul>
    <li><strong>Simplified client code:</strong> Clients can treat individual objects and composites uniformly.</li>
    <li><strong>Flexibility:</strong> It’s easy to add new leaf or composite classes without modifying existing code.</li>
    <li><strong>Hierarchy simplification:</strong> The same operations can be applied to the entire structure or to a specific sub-structure.</li>
  </ul>

  <hr>

<h2>Drawbacks</h2>
  <ul>
    <li><strong>Over-generalization:</strong> It can sometimes be hard to restrict certain behaviors to specific object types if the interface is too generic.</li>
    <li><strong>Complex management:</strong> Deleting or modifying children can become more complex if the hierarchy is very deep and varied.</li>
  </ul>

  <hr>

<h2>Related Patterns</h2>
  <ul>
    <li><strong>Decorator</strong>: Has a similar structure but with a different intent (adding responsibilities rather than building part-whole hierarchies).</li>
    <li><strong>Flyweight</strong>: Reduces memory usage by sharing state; can be combined with Composite in large structures.</li>
    <li><strong>Iterator</strong>: Useful for traversing Composites.</li>
  </ul>

  <hr>

<h2>Conclusion</h2>
  <p>
    The Composite Design Pattern is extremely powerful for scenarios where you need to represent and manipulate hierarchical, tree-like structures of objects. 
    By defining a common interface and allowing compositions to contain other objects, the pattern provides transparency to the client and improves code organization.
  </p>

</body>
</html>
