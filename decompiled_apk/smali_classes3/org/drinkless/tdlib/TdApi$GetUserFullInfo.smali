.class public Lorg/drinkless/tdlib/TdApi$GetUserFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUserFullInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$UserFullInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2e4d63a8


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13902
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13903
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13893
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13894
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetUserFullInfo;->userId:J

    .line 13895
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13899
    const v0, -0x2e4d63a8

    return v0
.end method
