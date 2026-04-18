.class public Lorg/drinkless/tdlib/TdApi$ImportedContacts;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImportedContacts"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7b49c5a2


# instance fields
.field public importerCount:[I

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27064
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27065
    return-void
.end method

.method public constructor <init>([J[I)V
    .locals 0
    .param p1, "jArr"    # [J
    .param p2, "iArr"    # [I

    .line 27054
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27055
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ImportedContacts;->userIds:[J

    .line 27056
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ImportedContacts;->importerCount:[I

    .line 27057
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27061
    const v0, 0x7b49c5a2

    return v0
.end method
