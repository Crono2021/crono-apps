.class public Lorg/drinkless/tdlib/TdApi$OptionValueBoolean;
.super Lorg/drinkless/tdlib/TdApi$OptionValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "OptionValueBoolean"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3c35f1e


# instance fields
.field public value:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17070
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$OptionValue;-><init>()V

    .line 17071
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 17061
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$OptionValue;-><init>()V

    .line 17062
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$OptionValueBoolean;->value:Z

    .line 17063
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17067
    const v0, 0x3c35f1e

    return v0
.end method
