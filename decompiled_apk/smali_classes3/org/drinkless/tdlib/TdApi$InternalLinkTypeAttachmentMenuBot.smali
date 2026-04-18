.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeAttachmentMenuBot;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeAttachmentMenuBot"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x644c4225


# instance fields
.field public botUsername:Ljava/lang/String;

.field public targetChat:Lorg/drinkless/tdlib/TdApi$TargetChat;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38106
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38107
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$TargetChat;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "targetChat"    # Lorg/drinkless/tdlib/TdApi$TargetChat;
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "str2"    # Ljava/lang/String;

    .line 38095
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 38096
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeAttachmentMenuBot;->targetChat:Lorg/drinkless/tdlib/TdApi$TargetChat;

    .line 38097
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeAttachmentMenuBot;->botUsername:Ljava/lang/String;

    .line 38098
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeAttachmentMenuBot;->url:Ljava/lang/String;

    .line 38099
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38103
    const v0, 0x644c4225

    return v0
.end method
