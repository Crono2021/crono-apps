.class public Lorg/drinkless/tdlib/TdApi$UpdateOption;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateOption"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x35b17404


# instance fields
.field public name:Ljava/lang/String;

.field public value:Lorg/drinkless/tdlib/TdApi$OptionValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34748
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34749
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$OptionValue;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "optionValue"    # Lorg/drinkless/tdlib/TdApi$OptionValue;

    .line 34738
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34739
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateOption;->name:Ljava/lang/String;

    .line 34740
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateOption;->value:Lorg/drinkless/tdlib/TdApi$OptionValue;

    .line 34741
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34745
    const v0, 0x35b17404

    return v0
.end method
