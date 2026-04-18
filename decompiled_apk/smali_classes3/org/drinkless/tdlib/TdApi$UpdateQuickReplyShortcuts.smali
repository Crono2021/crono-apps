.class public Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcuts;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateQuickReplyShortcuts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76e6fdc3


# instance fields
.field public shortcutIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21998
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21999
    return-void
.end method

.method public constructor <init>([I)V
    .locals 0
    .param p1, "iArr"    # [I

    .line 21989
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21990
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcuts;->shortcutIds:[I

    .line 21991
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21995
    const v0, -0x76e6fdc3

    return v0
.end method
