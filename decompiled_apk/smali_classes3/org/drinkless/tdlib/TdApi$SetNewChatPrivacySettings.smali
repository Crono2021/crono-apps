.class public Lorg/drinkless/tdlib/TdApi$SetNewChatPrivacySettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetNewChatPrivacySettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x69bf374f


# instance fields
.field public settings:Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19842
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19843
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;)V
    .locals 0
    .param p1, "newChatPrivacySettings"    # Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;

    .line 19833
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19834
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetNewChatPrivacySettings;->settings:Lorg/drinkless/tdlib/TdApi$NewChatPrivacySettings;

    .line 19835
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19839
    const v0, 0x69bf374f

    return v0
.end method
