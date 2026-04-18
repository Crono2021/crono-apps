.class public Lorg/drinkless/tdlib/TdApi$ResetPasswordResultDeclined;
.super Lorg/drinkless/tdlib/TdApi$ResetPasswordResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ResetPasswordResultDeclined"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x47a81f35


# instance fields
.field public retryDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 18870
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ResetPasswordResult;-><init>()V

    .line 18871
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 18861
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ResetPasswordResult;-><init>()V

    .line 18862
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ResetPasswordResultDeclined;->retryDate:I

    .line 18863
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 18867
    const v0, -0x47a81f35

    return v0
.end method
