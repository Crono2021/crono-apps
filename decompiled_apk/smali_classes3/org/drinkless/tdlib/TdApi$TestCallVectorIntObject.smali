.class public Lorg/drinkless/tdlib/TdApi$TestCallVectorIntObject;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestCallVectorIntObject"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestVectorIntObject;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6ccdd2fa


# instance fields
.field public f8024x:[Lorg/drinkless/tdlib/TdApi$TestInt;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20985
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$TestInt;)V
    .locals 0
    .param p1, "testIntArr"    # [Lorg/drinkless/tdlib/TdApi$TestInt;

    .line 20975
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20976
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestCallVectorIntObject;->f8024x:[Lorg/drinkless/tdlib/TdApi$TestInt;

    .line 20977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20981
    const v0, 0x6ccdd2fa

    return v0
.end method
