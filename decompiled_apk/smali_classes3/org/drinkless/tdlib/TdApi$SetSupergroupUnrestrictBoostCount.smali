.class public Lorg/drinkless/tdlib/TdApi$SetSupergroupUnrestrictBoostCount;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetSupergroupUnrestrictBoostCount"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x39ce30a3


# instance fields
.field public supergroupId:J

.field public unrestrictBoostCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 32088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32089
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 32078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 32079
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupUnrestrictBoostCount;->supergroupId:J

    .line 32080
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetSupergroupUnrestrictBoostCount;->unrestrictBoostCount:I

    .line 32081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 32085
    const v0, 0x39ce30a3

    return v0
.end method
