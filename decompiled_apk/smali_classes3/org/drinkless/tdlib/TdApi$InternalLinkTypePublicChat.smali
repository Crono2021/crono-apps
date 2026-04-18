.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypePublicChat;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypePublicChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x697a2d00


# instance fields
.field public chatUsername:Ljava/lang/String;

.field public draftText:Ljava/lang/String;

.field public openProfile:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38216
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38217
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 38205
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38206
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePublicChat;->chatUsername:Ljava/lang/String;

    .line 38207
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePublicChat;->draftText:Ljava/lang/String;

    .line 38208
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypePublicChat;->openProfile:Z

    .line 38209
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38213
    const v0, 0x697a2d00

    return v0
.end method
