.class public Lorg/drinkless/tdlib/TdApi$TestVectorIntObject;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestVectorIntObject"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x780f3da


# instance fields
.field public value:[Lorg/drinkless/tdlib/TdApi$TestInt;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21135
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TestInt;)V
    .locals 0
    .param p1, "testIntArr"    # [Lorg/drinkless/tdlib/TdApi$TestInt;

    .line 21125
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21126
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestVectorIntObject;->value:[Lorg/drinkless/tdlib/TdApi$TestInt;

    .line 21127
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21131
    const v0, 0x780f3da

    return v0
.end method
