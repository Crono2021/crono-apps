.class public Lorg/drinkless/tdlib/TdApi$GetMenuButton;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMenuButton"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BotMenuButton;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1a110bc0


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13092
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13093
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13083
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13084
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetMenuButton;->userId:J

    .line 13085
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13089
    const v0, -0x1a110bc0

    return v0
.end method
