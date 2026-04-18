.class public Lorg/drinkless/tdlib/TdApi$ToggleBotIsAddedToAttachmentMenu;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleBotIsAddedToAttachmentMenu"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x71a62166


# instance fields
.field public allowWriteAccess:Z

.field public botUserId:J

.field public isAdded:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41055
    return-void
.end method

.method public constructor <init>(JZZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z

    .line 41043
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41044
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleBotIsAddedToAttachmentMenu;->botUserId:J

    .line 41045
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleBotIsAddedToAttachmentMenu;->isAdded:Z

    .line 41046
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ToggleBotIsAddedToAttachmentMenu;->allowWriteAccess:Z

    .line 41047
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41051
    const v0, -0x71a62166

    return v0
.end method
