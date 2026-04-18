.class public Lorg/drinkless/tdlib/TdApi$TestVectorString;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestVectorString"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4baa1db


# instance fields
.field public value:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21152
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21153
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 21143
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21144
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestVectorString;->value:[Ljava/lang/String;

    .line 21145
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21149
    const v0, 0x4baa1db

    return v0
.end method
