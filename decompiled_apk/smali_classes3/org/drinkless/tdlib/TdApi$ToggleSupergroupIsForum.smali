.class public Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsForum;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleSupergroupIsForum"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x161dfe11


# instance fields
.field public hasForumTabs:Z

.field public isForum:Z

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41230
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41231
    return-void
.end method

.method public constructor <init>(JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 41219
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41220
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsForum;->supergroupId:J

    .line 41221
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsForum;->isForum:Z

    .line 41222
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleSupergroupIsForum;->hasForumTabs:Z

    .line 41223
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41227
    const v0, 0x161dfe11

    return v0
.end method
