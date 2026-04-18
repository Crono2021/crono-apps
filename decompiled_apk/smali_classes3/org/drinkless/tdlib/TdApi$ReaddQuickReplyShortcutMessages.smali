.class public Lorg/drinkless/tdlib/TdApi$ReaddQuickReplyShortcutMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReaddQuickReplyShortcutMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$QuickReplyMessages;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x17173f8e


# instance fields
.field public messageIds:[J

.field public shortcutName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29789
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "jArr"    # [J

    .line 29778
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29779
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ReaddQuickReplyShortcutMessages;->shortcutName:Ljava/lang/String;

    .line 29780
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReaddQuickReplyShortcutMessages;->messageIds:[J

    .line 29781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29785
    const v0, 0x17173f8e

    return v0
.end method
