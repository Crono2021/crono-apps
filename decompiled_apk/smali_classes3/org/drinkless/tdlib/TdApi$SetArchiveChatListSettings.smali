.class public Lorg/drinkless/tdlib/TdApi$SetArchiveChatListSettings;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetArchiveChatListSettings"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x34bab3f6


# instance fields
.field public settings:Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19410
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19411
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;)V
    .locals 0
    .param p1, "archiveChatListSettings"    # Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;

    .line 19401
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19402
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetArchiveChatListSettings;->settings:Lorg/drinkless/tdlib/TdApi$ArchiveChatListSettings;

    .line 19403
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19407
    const v0, -0x34bab3f6    # -1.2930058E7f

    return v0
.end method
