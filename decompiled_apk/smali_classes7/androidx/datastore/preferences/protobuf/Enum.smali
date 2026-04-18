.class public final Landroidx/datastore/preferences/protobuf/Enum;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;
.source "Enum.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/EnumOrBuilder;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/datastore/preferences/protobuf/Enum$Builder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite<",
        "Landroidx/datastore/preferences/protobuf/Enum;",
        "Landroidx/datastore/preferences/protobuf/Enum$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/EnumOrBuilder;"
    }
.end annotation


# static fields
.field private static final DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

.field public static final ENUMVALUE_FIELD_NUMBER:I = 0x2

.field public static final NAME_FIELD_NUMBER:I = 0x1

.field public static final OPTIONS_FIELD_NUMBER:I = 0x3

.field private static volatile PARSER:Landroidx/datastore/preferences/protobuf/Parser; = null
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/Enum;",
            ">;"
        }
    .end annotation
.end field

.field public static final SOURCE_CONTEXT_FIELD_NUMBER:I = 0x4

.field public static final SYNTAX_FIELD_NUMBER:I = 0x5


# instance fields
.field private enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Internal$ProtobufList<",
            "Landroidx/datastore/preferences/protobuf/EnumValue;",
            ">;"
        }
    .end annotation
.end field

.field private name_:Ljava/lang/String;

.field private options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroidx/datastore/preferences/protobuf/Internal$ProtobufList<",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;"
        }
    .end annotation
.end field

.field private sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

.field private syntax_:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1263
    new-instance v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/Enum;-><init>()V

    .line 1266
    .local v0, "defaultInstance":Landroidx/datastore/preferences/protobuf/Enum;
    sput-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    .line 1267
    const-class v1, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v1, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->registerDefaultInstance(Ljava/lang/Class;Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 1269
    .end local v0    # "defaultInstance":Landroidx/datastore/preferences/protobuf/Enum;
    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .line 18
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;-><init>()V

    .line 19
    const-string v0, ""

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->name_:Ljava/lang/String;

    .line 20
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Enum;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 21
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Enum;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 22
    return-void
.end method

.method static synthetic access$000()Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1

    .line 13
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method static synthetic access$100(Landroidx/datastore/preferences/protobuf/Enum;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Ljava/lang/String;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->setName(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1000(Landroidx/datastore/preferences/protobuf/Enum;Ljava/lang/Iterable;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Ljava/lang/Iterable;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->addAllEnumvalue(Ljava/lang/Iterable;)V

    return-void
.end method

.method static synthetic access$1100(Landroidx/datastore/preferences/protobuf/Enum;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;

    .line 13
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->clearEnumvalue()V

    return-void
.end method

.method static synthetic access$1200(Landroidx/datastore/preferences/protobuf/Enum;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->removeEnumvalue(I)V

    return-void
.end method

.method static synthetic access$1300(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->setOptions(ILandroidx/datastore/preferences/protobuf/Option;)V

    return-void
.end method

.method static synthetic access$1400(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->setOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V

    return-void
.end method

.method static synthetic access$1500(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/Option;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->addOptions(Landroidx/datastore/preferences/protobuf/Option;)V

    return-void
.end method

.method static synthetic access$1600(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->addOptions(ILandroidx/datastore/preferences/protobuf/Option;)V

    return-void
.end method

.method static synthetic access$1700(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->addOptions(Landroidx/datastore/preferences/protobuf/Option$Builder;)V

    return-void
.end method

.method static synthetic access$1800(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->addOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V

    return-void
.end method

.method static synthetic access$1900(Landroidx/datastore/preferences/protobuf/Enum;Ljava/lang/Iterable;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Ljava/lang/Iterable;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->addAllOptions(Ljava/lang/Iterable;)V

    return-void
.end method

.method static synthetic access$200(Landroidx/datastore/preferences/protobuf/Enum;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;

    .line 13
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->clearName()V

    return-void
.end method

.method static synthetic access$2000(Landroidx/datastore/preferences/protobuf/Enum;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;

    .line 13
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->clearOptions()V

    return-void
.end method

.method static synthetic access$2100(Landroidx/datastore/preferences/protobuf/Enum;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->removeOptions(I)V

    return-void
.end method

.method static synthetic access$2200(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V

    return-void
.end method

.method static synthetic access$2300(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V

    return-void
.end method

.method static synthetic access$2400(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->mergeSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V

    return-void
.end method

.method static synthetic access$2500(Landroidx/datastore/preferences/protobuf/Enum;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;

    .line 13
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->clearSourceContext()V

    return-void
.end method

.method static synthetic access$2600(Landroidx/datastore/preferences/protobuf/Enum;I)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->setSyntaxValue(I)V

    return-void
.end method

.method static synthetic access$2700(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/Syntax;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/Syntax;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->setSyntax(Landroidx/datastore/preferences/protobuf/Syntax;)V

    return-void
.end method

.method static synthetic access$2800(Landroidx/datastore/preferences/protobuf/Enum;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;

    .line 13
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->clearSyntax()V

    return-void
.end method

.method static synthetic access$300(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->setNameBytes(Landroidx/datastore/preferences/protobuf/ByteString;)V

    return-void
.end method

.method static synthetic access$400(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->setEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue;)V

    return-void
.end method

.method static synthetic access$500(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->setEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V

    return-void
.end method

.method static synthetic access$600(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/EnumValue;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->addEnumvalue(Landroidx/datastore/preferences/protobuf/EnumValue;)V

    return-void
.end method

.method static synthetic access$700(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->addEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue;)V

    return-void
.end method

.method static synthetic access$800(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/EnumValue$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 13
    invoke-direct {p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->addEnumvalue(Landroidx/datastore/preferences/protobuf/EnumValue$Builder;)V

    return-void
.end method

.method static synthetic access$900(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V
    .locals 0
    .param p0, "x0"    # Landroidx/datastore/preferences/protobuf/Enum;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 13
    invoke-direct {p0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->addEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V

    return-void
.end method

.method private addAllEnumvalue(Ljava/lang/Iterable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/EnumValue;",
            ">;)V"
        }
    .end annotation

    .line 248
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/EnumValue;>;"
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 249
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/AbstractMessageLite;->addAll(Ljava/lang/Iterable;Ljava/util/List;)V

    .line 251
    return-void
.end method

.method private addAllOptions(Ljava/lang/Iterable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;)V"
        }
    .end annotation

    .line 427
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/Option;>;"
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 428
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-static {p1, v0}, Landroidx/datastore/preferences/protobuf/AbstractMessageLite;->addAll(Ljava/lang/Iterable;Ljava/util/List;)V

    .line 430
    return-void
.end method

.method private addEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 236
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 237
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/EnumValue$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 238
    return-void
.end method

.method private addEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 209
    if-eqz p2, :cond_0

    .line 212
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 213
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 214
    return-void

    .line 210
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addEnumvalue(Landroidx/datastore/preferences/protobuf/EnumValue$Builder;)V
    .locals 2
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 224
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 225
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/EnumValue$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 226
    return-void
.end method

.method private addEnumvalue(Landroidx/datastore/preferences/protobuf/EnumValue;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 194
    if-eqz p1, :cond_0

    .line 197
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 198
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 199
    return-void

    .line 195
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 415
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 416
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Option$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 417
    return-void
.end method

.method private addOptions(ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 388
    if-eqz p2, :cond_0

    .line 391
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 392
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(ILjava/lang/Object;)V

    .line 393
    return-void

    .line 389
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private addOptions(Landroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 2
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 403
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 404
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/Option$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 405
    return-void
.end method

.method private addOptions(Landroidx/datastore/preferences/protobuf/Option;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 373
    if-eqz p1, :cond_0

    .line 376
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 377
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->add(Ljava/lang/Object;)Z

    .line 378
    return-void

    .line 374
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private clearEnumvalue()V
    .locals 1

    .line 260
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Enum;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 261
    return-void
.end method

.method private clearName()V
    .locals 1

    .line 75
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Enum;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/Enum;

    move-result-object v0

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->name_:Ljava/lang/String;

    .line 76
    return-void
.end method

.method private clearOptions()V
    .locals 1

    .line 439
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Enum;->emptyProtobufList()Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 440
    return-void
.end method

.method private clearSourceContext()V
    .locals 1

    .line 531
    const/4 v0, 0x0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 533
    return-void
.end method

.method private clearSyntax()V
    .locals 1

    .line 597
    const/4 v0, 0x0

    iput v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->syntax_:I

    .line 598
    return-void
.end method

.method private ensureEnumvalueIsMutable()V
    .locals 1

    .line 153
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->isModifiable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 154
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 155
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->mutableCopy(Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;)Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 157
    :cond_0
    return-void
.end method

.method private ensureOptionsIsMutable()V
    .locals 1

    .line 332
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->isModifiable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 333
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 334
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->mutableCopy(Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;)Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    .line 336
    :cond_0
    return-void
.end method

.method public static getDefaultInstance()Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1

    .line 1272
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method private mergeSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 2
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 512
    if-eqz p1, :cond_1

    .line 515
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    if-eqz v0, :cond_0

    .line 516
    invoke-static {}, Landroidx/datastore/preferences/protobuf/SourceContext;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/SourceContext;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 517
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 518
    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/SourceContext;->newBuilder(Landroidx/datastore/preferences/protobuf/SourceContext;)Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;->mergeFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;->buildPartial()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/SourceContext;

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    goto :goto_0

    .line 520
    :cond_0
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 523
    :goto_0
    return-void

    .line 513
    :cond_1
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method public static newBuilder()Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1

    .line 675
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->createBuilder()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum$Builder;

    return-object v0
.end method

.method public static newBuilder(Landroidx/datastore/preferences/protobuf/Enum;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p0, "prototype"    # Landroidx/datastore/preferences/protobuf/Enum;

    .line 678
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0, p0}, Landroidx/datastore/preferences/protobuf/Enum;->createBuilder(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum$Builder;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 652
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/Enum;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 658
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->parseDelimitedFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 616
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "data"    # Landroidx/datastore/preferences/protobuf/ByteString;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 623
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/ByteString;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 663
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "input"    # Landroidx/datastore/preferences/protobuf/CodedInputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 670
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Landroidx/datastore/preferences/protobuf/CodedInputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 640
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "input"    # Ljava/io/InputStream;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .line 647
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/io/InputStream;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 603
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom(Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "data"    # Ljava/nio/ByteBuffer;
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 610
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;Ljava/nio/ByteBuffer;Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom([B)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 628
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[B)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parseFrom([BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/Enum;
    .locals 1
    .param p0, "data"    # [B
    .param p1, "extensionRegistry"    # Landroidx/datastore/preferences/protobuf/ExtensionRegistryLite;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroidx/datastore/preferences/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    .line 635
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p0, p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;->parseFrom(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;[BLandroidx/datastore/preferences/protobuf/ExtensionRegistryLite;)Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0
.end method

.method public static parser()Landroidx/datastore/preferences/protobuf/Parser;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Landroidx/datastore/preferences/protobuf/Parser<",
            "Landroidx/datastore/preferences/protobuf/Enum;",
            ">;"
        }
    .end annotation

    .line 1278
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getParserForType()Landroidx/datastore/preferences/protobuf/Parser;

    move-result-object v0

    return-object v0
.end method

.method private removeEnumvalue(I)V
    .locals 1
    .param p1, "index"    # I

    .line 270
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 271
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->remove(I)Ljava/lang/Object;

    .line 272
    return-void
.end method

.method private removeOptions(I)V
    .locals 1
    .param p1, "index"    # I

    .line 449
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 450
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->remove(I)Ljava/lang/Object;

    .line 451
    return-void
.end method

.method private setEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 183
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 184
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/EnumValue$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 185
    return-void
.end method

.method private setEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 168
    if-eqz p2, :cond_0

    .line 171
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureEnumvalueIsMutable()V

    .line 172
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 173
    return-void

    .line 169
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setName(Ljava/lang/String;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .line 60
    if-eqz p1, :cond_0

    .line 64
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Enum;->name_:Ljava/lang/String;

    .line 65
    return-void

    .line 61
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setNameBytes(Landroidx/datastore/preferences/protobuf/ByteString;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 87
    if-eqz p1, :cond_0

    .line 90
    invoke-static {p1}, Landroidx/datastore/preferences/protobuf/Enum;->checkByteStringIsUtf8(Landroidx/datastore/preferences/protobuf/ByteString;)V

    .line 92
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->name_:Ljava/lang/String;

    .line 93
    return-void

    .line 88
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 362
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 363
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-virtual {p2}, Landroidx/datastore/preferences/protobuf/Option$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 364
    return-void
.end method

.method private setOptions(ILandroidx/datastore/preferences/protobuf/Option;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 347
    if-eqz p2, :cond_0

    .line 350
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum;->ensureOptionsIsMutable()V

    .line 351
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 352
    return-void

    .line 348
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    .line 500
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/SourceContext$Builder;->build()Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/SourceContext;

    iput-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 502
    return-void
.end method

.method private setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 485
    if-eqz p1, :cond_0

    .line 488
    iput-object p1, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 490
    return-void

    .line 486
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setSyntax(Landroidx/datastore/preferences/protobuf/Syntax;)V
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Syntax;

    .line 582
    if-eqz p1, :cond_0

    .line 586
    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/Syntax;->getNumber()I

    move-result v0

    iput v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->syntax_:I

    .line 587
    return-void

    .line 583
    :cond_0
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0
.end method

.method private setSyntaxValue(I)V
    .locals 0
    .param p1, "value"    # I

    .line 571
    iput p1, p0, Landroidx/datastore/preferences/protobuf/Enum;->syntax_:I

    .line 572
    return-void
.end method


# virtual methods
.method protected final dynamicMethod(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 8
    .param p1, "method"    # Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;
    .param p2, "arg0"    # Ljava/lang/Object;
    .param p3, "arg1"    # Ljava/lang/Object;

    .line 1208
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum$1;->$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke:[I

    invoke-virtual {p1}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$MethodToInvoke;->ordinal()I

    move-result v1

    aget v0, v0, v1

    const/4 v1, 0x0

    packed-switch v0, :pswitch_data_0

    .line 1256
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0

    .line 1253
    :pswitch_0
    return-object v1

    .line 1250
    :pswitch_1
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v0

    return-object v0

    .line 1235
    :pswitch_2
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 1236
    .local v0, "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/Enum;>;"
    if-nez v0, :cond_1

    .line 1237
    const-class v1, Landroidx/datastore/preferences/protobuf/Enum;

    monitor-enter v1

    .line 1238
    :try_start_0
    sget-object v2, Landroidx/datastore/preferences/protobuf/Enum;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    move-object v0, v2

    .line 1239
    if-nez v0, :cond_0

    .line 1240
    new-instance v2, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;

    sget-object v3, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-direct {v2, v3}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$DefaultInstanceBasedParser;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    move-object v0, v2

    .line 1243
    sput-object v0, Landroidx/datastore/preferences/protobuf/Enum;->PARSER:Landroidx/datastore/preferences/protobuf/Parser;

    .line 1245
    :cond_0
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 1247
    :cond_1
    :goto_0
    return-object v0

    .line 1232
    .end local v0    # "parser":Landroidx/datastore/preferences/protobuf/Parser;, "Landroidx/datastore/preferences/protobuf/Parser<Landroidx/datastore/preferences/protobuf/Enum;>;"
    :pswitch_3
    sget-object v0, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    return-object v0

    .line 1216
    :pswitch_4
    const-string/jumbo v1, "name_"

    const-string v2, "enumvalue_"

    const-class v3, Landroidx/datastore/preferences/protobuf/EnumValue;

    const-string/jumbo v4, "options_"

    const-class v5, Landroidx/datastore/preferences/protobuf/Option;

    const-string/jumbo v6, "sourceContext_"

    const-string/jumbo v7, "syntax_"

    filled-new-array/range {v1 .. v7}, [Ljava/lang/Object;

    move-result-object v0

    .line 1225
    .local v0, "objects":[Ljava/lang/Object;
    const-string v1, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0208\u0002\u001b\u0003\u001b\u0004\t\u0005\u000c"

    .line 1228
    .local v1, "info":Ljava/lang/String;
    sget-object v2, Landroidx/datastore/preferences/protobuf/Enum;->DEFAULT_INSTANCE:Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v2, v1, v0}, Landroidx/datastore/preferences/protobuf/Enum;->newMessageInfo(Landroidx/datastore/preferences/protobuf/MessageLite;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    return-object v2

    .line 1213
    .end local v0    # "objects":[Ljava/lang/Object;
    .end local v1    # "info":Ljava/lang/String;
    :pswitch_5
    new-instance v0, Landroidx/datastore/preferences/protobuf/Enum$Builder;

    invoke-direct {v0, v1}, Landroidx/datastore/preferences/protobuf/Enum$Builder;-><init>(Landroidx/datastore/preferences/protobuf/Enum$1;)V

    return-object v0

    .line 1210
    :pswitch_6
    new-instance v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-direct {v0}, Landroidx/datastore/preferences/protobuf/Enum;-><init>()V

    return-object v0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public getEnumvalue(I)Landroidx/datastore/preferences/protobuf/EnumValue;
    .locals 1
    .param p1, "index"    # I

    .line 139
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/EnumValue;

    return-object v0
.end method

.method public getEnumvalueCount()I
    .locals 1

    .line 128
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->size()I

    move-result v0

    return v0
.end method

.method public getEnumvalueList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/EnumValue;",
            ">;"
        }
    .end annotation

    .line 106
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getEnumvalueOrBuilder(I)Landroidx/datastore/preferences/protobuf/EnumValueOrBuilder;
    .locals 1
    .param p1, "index"    # I

    .line 150
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/EnumValueOrBuilder;

    return-object v0
.end method

.method public getEnumvalueOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "+",
            "Landroidx/datastore/preferences/protobuf/EnumValueOrBuilder;",
            ">;"
        }
    .end annotation

    .line 117
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->enumvalue_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .line 35
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->name_:Ljava/lang/String;

    return-object v0
.end method

.method public getNameBytes()Landroidx/datastore/preferences/protobuf/ByteString;
    .locals 1

    .line 48
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->name_:Ljava/lang/String;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getOptions(I)Landroidx/datastore/preferences/protobuf/Option;
    .locals 1
    .param p1, "index"    # I

    .line 318
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/Option;

    return-object v0
.end method

.method public getOptionsCount()I
    .locals 1

    .line 307
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->size()I

    move-result v0

    return v0
.end method

.method public getOptionsList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;"
        }
    .end annotation

    .line 285
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getOptionsOrBuilder(I)Landroidx/datastore/preferences/protobuf/OptionOrBuilder;
    .locals 1
    .param p1, "index"    # I

    .line 329
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    invoke-interface {v0, p1}, Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroidx/datastore/preferences/protobuf/OptionOrBuilder;

    return-object v0
.end method

.method public getOptionsOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "+",
            "Landroidx/datastore/preferences/protobuf/OptionOrBuilder;",
            ">;"
        }
    .end annotation

    .line 296
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->options_:Landroidx/datastore/preferences/protobuf/Internal$ProtobufList;

    return-object v0
.end method

.method public getSourceContext()Landroidx/datastore/preferences/protobuf/SourceContext;
    .locals 1

    .line 475
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    if-nez v0, :cond_0

    invoke-static {}, Landroidx/datastore/preferences/protobuf/SourceContext;->getDefaultInstance()Landroidx/datastore/preferences/protobuf/SourceContext;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getSyntax()Landroidx/datastore/preferences/protobuf/Syntax;
    .locals 2

    .line 559
    iget v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->syntax_:I

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Syntax;->forNumber(I)Landroidx/datastore/preferences/protobuf/Syntax;

    move-result-object v0

    .line 560
    .local v0, "result":Landroidx/datastore/preferences/protobuf/Syntax;
    if-nez v0, :cond_0

    sget-object v1, Landroidx/datastore/preferences/protobuf/Syntax;->UNRECOGNIZED:Landroidx/datastore/preferences/protobuf/Syntax;

    goto :goto_0

    :cond_0
    move-object v1, v0

    :goto_0
    return-object v1
.end method

.method public getSyntaxValue()I
    .locals 1

    .line 547
    iget v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->syntax_:I

    return v0
.end method

.method public hasSourceContext()Z
    .locals 1

    .line 464
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum;->sourceContext_:Landroidx/datastore/preferences/protobuf/SourceContext;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method
