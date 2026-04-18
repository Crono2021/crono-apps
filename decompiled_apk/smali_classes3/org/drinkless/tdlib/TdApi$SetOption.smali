.class public Lorg/drinkless/tdlib/TdApi$SetOption;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetOption"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7e0b4ef2


# instance fields
.field public name:Ljava/lang/String;

.field public value:Lorg/drinkless/tdlib/TdApi$OptionValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31649
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$OptionValue;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "optionValue"    # Lorg/drinkless/tdlib/TdApi$OptionValue;

    .line 31638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31639
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetOption;->name:Ljava/lang/String;

    .line 31640
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetOption;->value:Lorg/drinkless/tdlib/TdApi$OptionValue;

    .line 31641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31645
    const v0, 0x7e0b4ef2

    return v0
.end method
