.class public Lorg/drinkless/tdlib/TdApi$GetWebAppPlaceholder;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetWebAppPlaceholder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Outline;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x22c70d8f


# instance fields
.field public botUserId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14010
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 14011
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 14001
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 14002
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetWebAppPlaceholder;->botUserId:J

    .line 14003
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14007
    const v0, 0x22c70d8f

    return v0
.end method
