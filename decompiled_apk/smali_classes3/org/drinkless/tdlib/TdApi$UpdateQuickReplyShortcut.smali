.class public Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcut;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateQuickReplyShortcut"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x396cc731


# instance fields
.field public shortcut:Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21962
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21963
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;)V
    .locals 0
    .param p1, "quickReplyShortcut"    # Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;

    .line 21953
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21954
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateQuickReplyShortcut;->shortcut:Lorg/drinkless/tdlib/TdApi$QuickReplyShortcut;

    .line 21955
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21959
    const v0, -0x396cc731

    return v0
.end method
