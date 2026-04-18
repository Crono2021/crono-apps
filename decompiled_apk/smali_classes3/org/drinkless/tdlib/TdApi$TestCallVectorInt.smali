.class public Lorg/drinkless/tdlib/TdApi$TestCallVectorInt;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestCallVectorInt"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$TestVectorInt;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7f644561


# instance fields
.field public f8023x:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20964
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20965
    return-void
.end method

.method public constructor <init>([I)V
    .locals 0
    .param p1, "iArr"    # [I

    .line 20955
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 20956
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestCallVectorInt;->f8023x:[I

    .line 20957
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20961
    const v0, -0x7f644561

    return v0
.end method
