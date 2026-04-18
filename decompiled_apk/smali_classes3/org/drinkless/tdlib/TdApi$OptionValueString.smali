.class public Lorg/drinkless/tdlib/TdApi$OptionValueString;
.super Lorg/drinkless/tdlib/TdApi$OptionValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OptionValueString"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2d136e94


# instance fields
.field public value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17106
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$OptionValue;-><init>()V

    .line 17107
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 17097
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$OptionValue;-><init>()V

    .line 17098
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$OptionValueString;->value:Ljava/lang/String;

    .line 17099
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17103
    const v0, 0x2d136e94

    return v0
.end method
