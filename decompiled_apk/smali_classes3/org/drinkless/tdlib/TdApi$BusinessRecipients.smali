.class public Lorg/drinkless/tdlib/TdApi$BusinessRecipients;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessRecipients"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x33c6a70d


# instance fields
.field public chatIds:[J

.field public excludeSelected:Z

.field public excludedChatIds:[J

.field public selectContacts:Z

.field public selectExistingChats:Z

.field public selectNewChats:Z

.field public selectNonContacts:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51105
    return-void
.end method

.method public constructor <init>([J[JZZZZZ)V
    .locals 0
    .param p1, "jArr"    # [J
    .param p2, "jArr2"    # [J
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z
    .param p6, "z11"    # Z
    .param p7, "z12"    # Z

    .line 51089
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51090
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->chatIds:[J

    .line 51091
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->excludedChatIds:[J

    .line 51092
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->selectExistingChats:Z

    .line 51093
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->selectNewChats:Z

    .line 51094
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->selectContacts:Z

    .line 51095
    iput-boolean p6, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->selectNonContacts:Z

    .line 51096
    iput-boolean p7, p0, Lorg/drinkless/tdlib/TdApi$BusinessRecipients;->excludeSelected:Z

    .line 51097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51101
    const v0, 0x33c6a70d

    return v0
.end method
