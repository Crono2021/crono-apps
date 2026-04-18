.class public Lorg/drinkless/tdlib/TdApi$DisableAllSupergroupUsernames;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DisableAllSupergroupUsernames"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3246f5b0


# instance fields
.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11562
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11563
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 11553
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11554
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DisableAllSupergroupUsernames;->supergroupId:J

    .line 11555
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11559
    const v0, 0x3246f5b0

    return v0
.end method
