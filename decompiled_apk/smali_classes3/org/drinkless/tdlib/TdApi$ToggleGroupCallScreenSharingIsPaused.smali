.class public Lorg/drinkless/tdlib/TdApi$ToggleGroupCallScreenSharingIsPaused;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGroupCallScreenSharingIsPaused"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5f84aca0


# instance fields
.field public groupCallId:I

.field public isPaused:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33308
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33309
    return-void
.end method

.method public constructor <init>(IZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z

    .line 33298
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33299
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallScreenSharingIsPaused;->groupCallId:I

    .line 33300
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallScreenSharingIsPaused;->isPaused:Z

    .line 33301
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33305
    const v0, -0x5f84aca0

    return v0
.end method
