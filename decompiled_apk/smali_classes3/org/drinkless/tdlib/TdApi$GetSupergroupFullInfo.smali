.class public Lorg/drinkless/tdlib/TdApi$GetSupergroupFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetSupergroupFullInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x418d4038


# instance fields
.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13759
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13749
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13750
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetSupergroupFullInfo;->supergroupId:J

    .line 13751
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13755
    const v0, 0x418d4038

    return v0
.end method
