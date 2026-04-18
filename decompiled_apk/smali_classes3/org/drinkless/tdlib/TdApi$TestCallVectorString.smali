.class public Lorg/drinkless/tdlib/TdApi$TestCallVectorString;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestCallVectorString"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestVectorString;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x185ac144


# instance fields
.field public f8025x:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 21005
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 20995
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20996
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestCallVectorString;->f8025x:[Ljava/lang/String;

    .line 20997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21001
    const v0, -0x185ac144

    return v0
.end method
