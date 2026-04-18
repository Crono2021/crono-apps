.class public Lorg/drinkless/tdlib/TdApi$TestVectorInt;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestVectorInt"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2362de6b


# instance fields
.field public value:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21116
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21117
    return-void
.end method

.method public constructor <init>([I)V
    .locals 0
    .param p1, "iArr"    # [I

    .line 21107
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21108
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestVectorInt;->value:[I

    .line 21109
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21113
    const v0, 0x2362de6b

    return v0
.end method
