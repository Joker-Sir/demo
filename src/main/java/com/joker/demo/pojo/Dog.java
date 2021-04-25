package com.joker.demo.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Data是一个复合注解
 * 包含了EqualsAndHashCode注解 默认不关联父类 会导致子类Hashcode计算结果一致
 * 重写equals方法比较了其类中的属性。
 * */
// @Setter
// @Getter
@Data
public class Dog {

    String name;
    String color;
    String type;

}


/* @Data注解编译后的代码
package com.joker.demo.pojo;

public class Dog {
    String name;
    String color;
    String type;

    public Dog() {
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public String getType() {
        return this.type;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Dog)) {
            return false;
        } else {
            Dog other = (Dog)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$name = this.getName();
                    Object other$name = other.getName();
                    if (this$name == null) {
                        if (other$name == null) {
                            break label47;
                        }
                    } else if (this$name.equals(other$name)) {
                        break label47;
                    }

                    return false;
                }

                Object this$color = this.getColor();
                Object other$color = other.getColor();
                if (this$color == null) {
                    if (other$color != null) {
                        return false;
                    }
                } else if (!this$color.equals(other$color)) {
                    return false;
                }

                Object this$type = this.getType();
                Object other$type = other.getType();
                if (this$type == null) {
                    if (other$type != null) {
                        return false;
                    }
                } else if (!this$type.equals(other$type)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Dog;
    }

    public int hashCode() {
        int PRIME = true;
        int result = 1;
        Object $name = this.getName();
        int result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $color = this.getColor();
        result = result * 59 + ($color == null ? 43 : $color.hashCode());
        Object $type = this.getType();
        result = result * 59 + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "Dog(name=" + this.getName() + ", color=" + this.getColor() + ", type=" + this.getType() + ")";
    }
}

* */