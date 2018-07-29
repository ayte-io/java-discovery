package io.ayte.utility.discovery.compilation.reader;

import io.ayte.utility.discovery.api.v1.AccessibleSymbolCollection;
import io.ayte.utility.discovery.api.v1.SymbolCollection;
import io.ayte.utility.discovery.api.v1.reference.MethodArgumentReference;
import io.ayte.utility.discovery.compilation.Reader;
import io.ayte.utility.discovery.compilation.Types;
import lombok.val;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.Collections;
import java.util.Set;

public class ParameterReader implements Reader {
    @Override
    public SymbolCollection read(AccessibleSymbolCollection collection, Element element) {
        val parent = MethodReader.convert(element.getEnclosingElement());
        val name = Types.getName(element);
        val reference = new MethodArgumentReference<>(parent, name);
        return collection.addMethodArgument(reference);
    }

    @Override
    public Set<ElementKind> getProcessedElementKinds() {
        return Collections.singleton(ElementKind.PARAMETER);
    }
}
