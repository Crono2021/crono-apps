.class public Lorg/drinkless/tdlib/TdApi$SetQuickReplyShortcutName;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetQuickReplyShortcutName"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xb20f471


# instance fields
.field public name:Ljava/lang/String;

.field public shortcutId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 31828
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31829
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 31818
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 31819
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetQuickReplyShortcutName;->shortcutId:I

    .line 31820
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetQuickReplyShortcutName;->name:Ljava/lang/String;

    .line 31821
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 31825
    const v0, 0xb20f471

    return v0
.end method
